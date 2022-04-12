package com.futuretech.pdfreaderconverter.ui.editing

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenStarted
import androidx.viewpager.widget.ViewPager
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.ActivityEditImageScreenBinding
import com.futuretech.pdfreaderconverter.dialog.SaveAsPdfDialog
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.ui.base.BaseActivity
import com.futuretech.pdfreaderconverter.ui.croping.CropScreen
import com.futuretech.pdfreaderconverter.ui.filter.FilterScreen
import com.futuretech.pdfreaderconverter.ui.home.HomeFiles
import com.futuretech.pdfreaderconverter.utility.Constants.CROP
import com.futuretech.pdfreaderconverter.utility.Constants.CROP_IMAGE_RESULT
import com.futuretech.pdfreaderconverter.utility.Constants.FILTERS
import com.futuretech.pdfreaderconverter.utility.Constants.FILTER_IMAGE_RESULT
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_POS
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_QUEUE_LIST
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_URI_PATH
import com.futuretech.pdfreaderconverter.utility.Constants.PDF
import com.futuretech.pdfreaderconverter.utility.FileOperation.getOutputFileDirectory
import com.futuretech.pdfreaderconverter.utility.Logger
import com.itextpdf.text.Document
import com.itextpdf.text.DocumentException
import com.itextpdf.text.Image
import com.itextpdf.text.PageSize
import com.itextpdf.text.pdf.PdfWriter
import kotlinx.coroutines.*
import java.io.*

class EditImageScreen : BaseActivity() {

    private lateinit var saveAsPDFDialog: SaveAsPdfDialog
    private val editImageBinding: ActivityEditImageScreenBinding by lazy {

        ActivityEditImageScreenBinding.inflate(layoutInflater)
    }
    private var uriPath: String = ""
    private lateinit var fileObj: FileModel
    private var fileArrayList = ArrayList<FileModel>()
    private lateinit var outputDirectory: File
    private var mCurrentImageIndex: Int = 0
    private lateinit var imageViewPagerAdapter: ImageViewPagerAdapter
    var imageQueueArrayList: ArrayList<ImageQueue> = ArrayList()
    private var job = Job()
    val scope = CoroutineScope(Dispatchers.Main + job)
    private var tempImageQueueArrayList: ArrayList<ImageQueue> = ArrayList()
    private var photoFile: File? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(editImageBinding.root)


        checkIntentValues()
        setImageNumber(editImageBinding.viewPagerImages.currentItem)
        setToolbar()
        setListener()


    }

    private fun checkIntentValues() {

        if (intent != null) {
            imageQueueArrayList =
                intent.getParcelableArrayListExtra<ImageQueue>(IMAGE_QUEUE_LIST) as ArrayList<ImageQueue>
            imageViewPagerAdapter = ImageViewPagerAdapter(imageQueueArrayList)
            editImageBinding.viewPagerImages.adapter = imageViewPagerAdapter

            disableNextPreviousButton()
        }
    }

    private fun setImageNumber(selectedPos: Int) {
        if (selectedPos < 0 || selectedPos >= imageQueueArrayList.size) {
            return
        }
        editImageBinding.tvImagesNo.text = String.format(
            "%d / %d",
            selectedPos + 1,
            imageQueueArrayList.size
        )

        if (selectedPos == 0) {
            editImageBinding.iVPreviousImage.isEnabled = false
            editImageBinding.iVPreviousImage.alpha = 0.5f
        }
        editImageBinding.viewPagerImages.currentItem = selectedPos
    }

    private fun disableNextPreviousButton() {
        if (imageQueueArrayList.size == 1) {

            editImageBinding.iVPreviousImage.isEnabled = false
            editImageBinding.iVPreviousImage.alpha = 0.5f
            editImageBinding.iVNextImage.isEnabled = false
            editImageBinding.iVNextImage.alpha = 0.5f
        }
    }


    private fun nextImageClicked() {
        if (imageQueueArrayList.size == 0) {
            return
        }
        /*mCurrentImageIndex =
            (mCurrentImageIndex + 1) % imageQueueArrayList.size*/
//        setImageNumber(mCurrentImageIndex)

        if (editImageBinding.viewPagerImages.currentItem < editImageBinding.viewPagerImages.adapter?.count!!) {
            setImageNumber(editImageBinding.viewPagerImages.currentItem + 1)
            if (editImageBinding.viewPagerImages.currentItem == editImageBinding.viewPagerImages.adapter?.count!! - 1) {
                editImageBinding.iVNextImage.isEnabled = false
                editImageBinding.iVNextImage.alpha = 0.5f
            }
        }

        if (editImageBinding.viewPagerImages.currentItem > 0 && editImageBinding.viewPagerImages.currentItem < editImageBinding.viewPagerImages.adapter?.count!!) {
            editImageBinding.iVPreviousImage.isEnabled = true
            editImageBinding.iVPreviousImage.alpha = 1.0f

        }

        /* disableNextBtn()*/
    }

    private fun previousImageClicked() {
        if (imageQueueArrayList.size == 0) {
            return
        }
        if (mCurrentImageIndex == 0) {
            mCurrentImageIndex = imageQueueArrayList.size
        }
        if (editImageBinding.viewPagerImages.currentItem > 0) {
            setImageNumber(editImageBinding.viewPagerImages.currentItem - 1)
        }

        /*mCurrentImageIndex =
            (mCurrentImageIndex - 1) % imageQueueArrayList.size*/
//        setImageNumber(mCurrentImageIndex)

        if (editImageBinding.viewPagerImages.currentItem == 0) {
            editImageBinding.iVPreviousImage.isEnabled = false
            editImageBinding.iVPreviousImage.alpha = 0.5f
        }
        if (editImageBinding.viewPagerImages.currentItem < editImageBinding.viewPagerImages.adapter?.count!! && editImageBinding.viewPagerImages.currentItem > 0) {
            editImageBinding.iVNextImage.isEnabled = true
            editImageBinding.iVNextImage.alpha = 1.0f
        }

        /*disablePreviousBtn()*/

    }


    private fun setListener() {

        editImageBinding.apply {

            toolbar.iVBackArrow.setOnClickListener {
                showConfirmationDialog(this@EditImageScreen, supportFragmentManager) { activity ->
                    activity.finish()
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
            }

            iVPreviousImage.setOnClickListener {
                previousImageClicked()
            }
            iVNextImage.setOnClickListener {
                nextImageClicked()
            }
            cLCropImage.setOnClickListener {
                if (disableClick()) {
                    startCropScreen()
                }
            }
            cLFilterImage.setOnClickListener {

                if (disableClick()) {
                    startFiltersScreen()
                }
            }
            cLDone.setOnClickListener {

//                setFileData()
                showSaveAsPDFDialog()

            }

            viewPagerImages.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int,
                ) {

                }

                override fun onPageSelected(position: Int) {
                    mCurrentImageIndex = position
                    setImageNumber(position)

                    if (position == 0) {
                        iVPreviousImage.isEnabled = false
                        iVPreviousImage.alpha = 0.5f
                    } else {
                        iVPreviousImage.isEnabled = true
                        iVPreviousImage.alpha = 1.0f
                    }
                    if (position == imageQueueArrayList.size - 1) {
                        iVNextImage.isEnabled = false
                        iVNextImage.alpha = 0.5f
                    } else {
                        iVNextImage.isEnabled = true
                        iVNextImage.alpha = 1.0f
                    }
                }

                override fun onPageScrollStateChanged(state: Int) {

                }
            })
        }
    }

    private fun setFileData(edtTitle: String) {

        deleteQueueImage()
        fileObj =
            FileModel(
                edtTitle,
                getCurrentDate(),
                imageQueueArrayList.size,
                imageQueueArrayList,
                isPdf = true
            )
        fileArrayList.add(
            fileObj
        )
        lifecycleScope.launch {
            fileViewModel.insertFile(fileObj)
        }
        startHomeScreen()

    }

    private fun showSaveAsPDFDialog() {
        fileObj =
            FileModel(
                getTitleCurrentDate(resources.getString(R.string.title)),
                getCurrentDate(),
                imageQueueArrayList.size,
                imageQueueArrayList,
                isPdf = false
            )
        saveAsPDFDialog =
            SaveAsPdfDialog(
                fileObj,
                fun(
                    clickItem: FileModel,
                    converterString: String,
                    quality: Int,
                ) {
                    handleAction(clickItem, converterString, quality)
                })
        saveAsPDFDialog.isCancelable = false
        saveAsPDFDialog.show(
            supportFragmentManager,
            SaveAsPdfDialog.TAG
        )
    }

    private fun handleAction(
        clickItem: FileModel,
        converterString: String,
        quality: Int
    ) {

        when (converterString) {

            PDF -> {
                val edtTitle =
                    saveAsPDFDialog.dialogSaveAsPdfBinding.edtName.text.trim()
                        .toString()
                outputDirectory =
                    getOutputFileDirectory(getString(R.string.pdf_dir))
                outputDirectory.listFiles { file ->
                    edtTitle.lowercase().trim()
                        .contains(file.nameWithoutExtension.lowercase().trim())
                }!!.maxOrNull()?.let {

                    if (it.nameWithoutExtension.lowercase().trim() == edtTitle) {
                        showToast(resources.getString(R.string.file_already_exist))
                        return
                    }
                }
                scope.launch {
                    val applyPDFDialog =
                        showLoadingDialog(
                            supportFragmentManager,
                            getString(R.string.processing)
                        )
                    scope.async(Dispatchers.IO) {
                        tempImageQueueArrayList.clear()
                        tempImageQueueArrayList = ArrayList()
                        for (imageQueue in clickItem.imageQueueArrayList!!) {
                            if (!imageQueue.uriPath.isNullOrEmpty()) {
                                tempImageQueueArrayList.add(imageQueue)
                            }
                        }
                        val arrayList: ArrayList<Bitmap> = ArrayList()

                        val it: Iterator<ImageQueue> = tempImageQueueArrayList.iterator()

                        while (it.hasNext()) {
                            val next: ImageQueue = it.next()

                            try {

                                val options = BitmapFactory.Options()
                                options.inPreferredConfig = Bitmap.Config.ARGB_8888
                                BitmapFactory.decodeStream(
                                    FileInputStream(next.uriPath),
                                    null as Rect?,
                                    options
                                )?.let { it1 -> arrayList.add(it1) }
                            } catch (e: IOException) {

                                e.printStackTrace()
                            }

                        }
                        createPdfFromBitmap(edtTitle, arrayList, quality)
                    }.await()

                    if (applyPDFDialog.isVisible) {
                        applyPDFDialog.dismiss()
                    }
                    setFileData(edtTitle)
//                    updateFileModel(edtTitle, clickItem, isPDF = true)
                    showToast(photoFile?.absolutePath!!)
                }
            }
        }

    }

    private fun createPdfFromBitmap(
        edtTitle: String,
        bitmapArrayList: ArrayList<Bitmap>,
        quality: Int,
    ) {

        val document = Document()
        try {

            outputDirectory =
                getOutputFileDirectory(getString(R.string.pdf_dir))

            photoFile = createPdfFile(
                outputDirectory,
                edtTitle,
                ".pdf"
            )

            PdfWriter.getInstance(document, FileOutputStream(photoFile))
            document.open()
            document.addCreationDate()
            document.addAuthor(resources.getString(R.string.app_name))
            document.addCreator(resources.getString(R.string.app_name))
            val it: Iterator<Bitmap> = bitmapArrayList.iterator()

            while (it.hasNext()) {
                document.pageSize = PageSize.A4
                document.newPage()
                val byteArrayOutputStream = ByteArrayOutputStream()
                it.next().compress(Bitmap.CompressFormat.JPEG, quality, byteArrayOutputStream)
                val instance = Image.getInstance(byteArrayOutputStream.toByteArray())
                when (quality) {
                    40 -> {
                        instance.compressionLevel = 1
                    }
                    55 -> {
                        instance.compressionLevel = 4
                    }
                    65 -> {
                        instance.compressionLevel = 7
                    }
                    80 -> {
                        instance.compressionLevel = 9
                    }
                }
//                instance.compressionLevel = qualityMod.toInt()
                Logger.debug("CompressQuality::=>", quality.toString())
                instance.scaleToFit(PageSize.A4.width, PageSize.A4.height)
                instance.setAbsolutePosition(
                    (PageSize.A4.width - instance.scaledWidth) / 2.0f,
                    (PageSize.A4.height - instance.scaledHeight) / 2.0f
                )
                document.add(instance)
            }

            document.close()


        } catch (e: DocumentException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    private fun updateFileModel(
        edtTitle: String,
        clickItem: FileModel,
        isPDF: Boolean,
    ) {
        lifecycleScope.launch {
            whenStarted {
                withContext(Dispatchers.IO) {
                    fileViewModel.updateFile(
                        edtTitle,
                        /*clickItem.timestamp*/getCurrentDate(),
                        imageQueueArrayList.size,
                        imageQueueArrayList,
                        isPDF, clickItem.title
                    )
                }
            }
        }

        startHomeScreen()
    }

    private fun startHomeScreen() {
        val intent = Intent(this, HomeFiles::class.java)
        startActivity(intent)
        overridePendingTransition(
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
        finish()
    }

    private fun deleteQueueImage() {

        lifecycleScope.launch {

            imageQueueViewModel.deleteAllQueueImages()
        }
    }

    private fun setToolbar() {
        editImageBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        editImageBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        editImageBinding.toolbar.tvToolbarTitle.setText(R.string.title)
    }

    override fun onBackPressed() {
        showConfirmationDialog(this@EditImageScreen, supportFragmentManager) { activity ->
            activity.finish()
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }

    @SuppressLint("LogNotTimber")
    var cropImageLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CROP_IMAGE_RESULT) {
            val intent: Intent? = it.data
            if (intent != null) {
                uriPath = intent.getStringExtra(IMAGE_URI_PATH).toString()
                mCurrentImageIndex = intent.getIntExtra(IMAGE_POS, -1)
                imageQueueArrayList =
                    intent.getParcelableArrayListExtra<ImageQueue>(IMAGE_QUEUE_LIST) as ArrayList<ImageQueue>
                if (imageQueueArrayList.size > 0) {
                    setAdapter()
                    editImageBinding.viewPagerImages.currentItem = mCurrentImageIndex
                }
            }
        }
    }

    private fun setAdapter() {
        imageViewPagerAdapter = ImageViewPagerAdapter(imageQueueArrayList)
        editImageBinding.viewPagerImages.adapter = imageViewPagerAdapter
        disableNextPreviousButton()
    }

    private fun startCropScreen() {
        val intent = Intent(this, CropScreen::class.java)
        intent.putExtra(IMAGE_POS, editImageBinding.viewPagerImages.currentItem)
        intent.putExtra(
            IMAGE_URI_PATH,
            imageQueueArrayList[editImageBinding.viewPagerImages.currentItem].uriPath
        )
        intent.putExtra(IMAGE_QUEUE_LIST, imageQueueArrayList)
        intent.putExtra(CROP, true)
        cropImageLauncher.launch(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun startFiltersScreen() {
        val intent = Intent(this, FilterScreen::class.java)
        intent.putExtra(IMAGE_POS, editImageBinding.viewPagerImages.currentItem)
        intent.putExtra(
            IMAGE_URI_PATH,
            imageQueueArrayList[editImageBinding.viewPagerImages.currentItem].uriPath
        )
        intent.putExtra(IMAGE_QUEUE_LIST, imageQueueArrayList)
        intent.putExtra(FILTERS, true)
        filterLauncher.launch(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    @SuppressLint("LogNotTimber")
    var filterLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == FILTER_IMAGE_RESULT) {
            val intent: Intent? = it.data
            if (intent != null) {
                uriPath = intent.getStringExtra(IMAGE_URI_PATH).toString()
                mCurrentImageIndex = intent.getIntExtra(IMAGE_POS, -1)
                imageQueueArrayList =
                    intent.getParcelableArrayListExtra<ImageQueue>(IMAGE_QUEUE_LIST) as ArrayList<ImageQueue>
                if (imageQueueArrayList.size > 0) {
                    setAdapter()
                    editImageBinding.viewPagerImages.currentItem = mCurrentImageIndex
                }
            }
        }
    }

}