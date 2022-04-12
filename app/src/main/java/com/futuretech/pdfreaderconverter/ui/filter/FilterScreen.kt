package com.futuretech.pdfreaderconverter.ui.filter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.exifinterface.media.ExifInterface
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.ActivityFilterScreenBinding
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.FilterScreenModel
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen
import com.futuretech.pdfreaderconverter.utility.Constants.FILTER_IMAGE_RESULT
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_POS
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_QUEUE_LIST
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_URI_PATH
import com.futuretech.pdfreaderconverter.utility.FileOperation.getOutputFileDirectory
import com.futuretech.pdfreaderconverter.utility.FileOperation.getUriPath
import com.futuretech.pdfreaderconverter.utility.Logger
import kotlinx.coroutines.*
import java.io.File

class FilterScreen : AppCompatActivity() {

    private val filterScreenBinding: ActivityFilterScreenBinding by lazy {
        ActivityFilterScreenBinding.inflate(layoutInflater)
    }

    private lateinit var photoFile: File
    private var rotatedBitmap: Bitmap? = null
    private var mCurrentImageIndex: Int = 0
    private var uriPath: String = ""
    private var imageQueueArrayList: ArrayList<ImageQueue> = ArrayList()
    private val colorFilter: ColorFilters = ColorFilters()
    private var job = Job()
    val scope = CoroutineScope(Dispatchers.Main + job)
    private lateinit var outputDirectory: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(filterScreenBinding.root)

        setIntentData()
        setToolbar()
        setListener()
        setFiltersAdapter()

        outputDirectory = getOutputFileDirectory(resources.getString(R.string.app_name))
        photoFile = createFile(
            outputDirectory
        )
        Logger.debug("DIRECTORY", outputDirectory.toString())

    }

    private fun setIntentData() {
        if (intent != null) {
            mCurrentImageIndex = intent.getIntExtra(IMAGE_POS, -1)
            uriPath = intent.getStringExtra(IMAGE_URI_PATH).toString()
            imageQueueArrayList =
                intent.getParcelableArrayListExtra<ImageQueue>(IMAGE_QUEUE_LIST) as ArrayList<ImageQueue>
            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, getUriPath(uriPath))
            rotatedBitmap = rotateBitmap(
                bitmap!!,
                ExifInterface(
                    contentResolver?.openInputStream(Uri.fromFile(File(uriPath)))!!
                ).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)
            )
            filterScreenBinding.iVImage.setImageBitmap(rotatedBitmap)
        }
    }

    private fun setFiltersAdapter() {
        filterScreenBinding.rVFilterItem.layoutManager =
            LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        filterScreenBinding.rVFilterItem.itemAnimator = DefaultItemAnimator()
        val adapter = FiltersScreenAdapter(fun(clickItem: FilterScreenModel, pos: Int) {
            handleClickAction(
                clickItem,
                pos
            )
        })
        filterScreenBinding.rVFilterItem.adapter = adapter
        adapter.submitList(getColorFilterNameArrayList())
    }

    private fun getColorFilterNameArrayList(): ArrayList<FilterScreenModel> {
        val icon: Bitmap = BitmapFactory.decodeResource(
            resources,
            R.drawable.ic_filter_thumbnail
        )
        val colorFilterNameArrayList: ArrayList<FilterScreenModel> = ArrayList()
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Original", /*rotatedBitmap*/
                icon,
                isSelected = true
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Sarurize", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Mono", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Tone", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Natural", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Mellow", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Luv", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Soft", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Grey", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Sketchy", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Emerald", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        colorFilterNameArrayList.add(
            FilterScreenModel(
                "Blurry", /*rotatedBitmap*/
                icon,
                isSelected = false
            )
        )
        return colorFilterNameArrayList
    }

    private fun handleClickAction(item: FilterScreenModel, pos: Int) {
        if (item.isSelected) {
            when (pos) {
                0 -> {
                    filterScreenBinding.iVImage.setImageBitmap(rotatedBitmap)
                }
                1 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter1(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                2 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter2(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                3 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter3(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                4 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter4(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                5 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter5(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                6 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter6(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                7 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter7(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                8 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter8(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                9 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter9(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                10 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter10(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
                11 -> {
                    filterScreenBinding.iVImage.setImageBitmap(
                        colorFilter.filter11(
                            applicationContext,
                            rotatedBitmap!!
                        )
                    )
                }
            }

        }
    }

    private fun setToolbar() {
        filterScreenBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        filterScreenBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        filterScreenBinding.toolbar.tvToolbarTitle.setText(R.string.filter)
    }

    private fun setListener() {
        filterScreenBinding.toolbar.iVBackArrow.setOnClickListener {
            if (disableClick()) {
                showConfirmationDialog(this@FilterScreen, supportFragmentManager) { activity ->
                    setResult(RESULT_CANCELED)
                    activity.finish()
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
            }
        }
        filterScreenBinding.cLApply.setOnClickListener {
            if (disableClick()) {
                val applyFilterDialog =
                    showLoadingDialog(supportFragmentManager, getString(R.string.processing))

                scope.launch {
                    scope.async(Dispatchers.IO) {
                        val bitmap = getMainFrameBitmap(filterScreenBinding.iVImage)!!
                        File(uriPath).writeBitmap(bitmap, Bitmap.CompressFormat.PNG, 100)

                    }.await()

                    if (applyFilterDialog.isVisible) {
                        applyFilterDialog.dismiss()
                    }
                    val intent = Intent(this@FilterScreen, EditImageScreen::class.java)
                    intent.putExtra(IMAGE_POS, mCurrentImageIndex)
                    intent.putExtra(
                        IMAGE_URI_PATH,
                        imageQueueArrayList[mCurrentImageIndex].uriPath
                    )
                    intent.putExtra(IMAGE_QUEUE_LIST, imageQueueArrayList)
                    setResult(FILTER_IMAGE_RESULT, intent)
                    finish()
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                }
            }
        }
    }

    override fun onBackPressed() {
        showConfirmationDialog(this@FilterScreen, supportFragmentManager) { activity ->
            setResult(RESULT_CANCELED)
            activity.finish()
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }
}