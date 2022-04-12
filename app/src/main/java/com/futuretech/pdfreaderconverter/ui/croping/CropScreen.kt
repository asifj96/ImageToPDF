package com.futuretech.pdfreaderconverter.ui.croping

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.exifinterface.media.ExifInterface
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.ActivityCropScreenBinding
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen
import com.futuretech.pdfreaderconverter.utility.Constants.CROP_IMAGE_RESULT
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_POS
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_QUEUE_LIST
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_URI_PATH
import com.futuretech.pdfreaderconverter.utility.FileOperation.getOutputFileDirectory
import com.futuretech.pdfreaderconverter.utility.FileOperation.getUriPath
import com.futuretech.pdfreaderconverter.utility.Logger
import kotlinx.coroutines.*
import java.io.File

class CropScreen : AppCompatActivity() {

    private lateinit var photoFile: File
    private var mCurrentImageIndex: Int = 0
    private var uriPath: String = ""
    private var rotatedBitmap: Bitmap? = null
    private var imageQueueArrayList: ArrayList<ImageQueue> = ArrayList()
    private lateinit var outputDirectory: File
    private var job = Job()
    val scope = CoroutineScope(Dispatchers.Main + job)

    private var angle: Int = 90

    private val cropScreenBinding: ActivityCropScreenBinding by lazy {
        ActivityCropScreenBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(cropScreenBinding.root)

        setToolbar()
        setListener()
        setIntentData()

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
                intent.getParcelableArrayListExtra<ImageQueue>(IMAGE_QUEUE_LIST) as java.util.ArrayList<ImageQueue>

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, getUriPath(uriPath))
            rotatedBitmap = rotateBitmap(
                bitmap!!,
                ExifInterface(
                    contentResolver?.openInputStream(Uri.fromFile(File(uriPath)))!!
                ).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1)
            )
            cropScreenBinding.cropView.setImageBitmap(rotatedBitmap)
        }
    }


    private fun setToolbar() {
        cropScreenBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        cropScreenBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        cropScreenBinding.toolbar.tvToolbarTitle.setText(R.string.crop)
    }

    private fun setListener() {
        cropScreenBinding.toolbar.iVBackArrow.setOnClickListener {
            if (disableClick()) {
                showConfirmationDialog(this@CropScreen, supportFragmentManager) { activity ->
                    activity.finish()
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }
            }
        }
        cropScreenBinding.cLFlip.setOnClickListener {

            cropScreenBinding.cropView.isFlippedHorizontally = true
            cropScreenBinding.cropView.isFlippedVertically = true
        }
        cropScreenBinding.cLApply.setOnClickListener {
            val applyCroppingDialog =
                showLoadingDialog(supportFragmentManager, getString(R.string.processing))
            if (disableClick()) {

                scope.launch {
                    val croppedBitmap: Bitmap = cropScreenBinding.cropView.croppedImage
                    scope.async(Dispatchers.IO) {
                        File(uriPath).writeBitmap(croppedBitmap, Bitmap.CompressFormat.PNG, 100)
                    }.await()

                    if (applyCroppingDialog.isVisible) {
                        applyCroppingDialog.dismiss()
                    }
                    val intent = Intent(this@CropScreen, EditImageScreen::class.java)
                    intent.putExtra(IMAGE_POS, mCurrentImageIndex)
                    intent.putExtra(
                        IMAGE_URI_PATH,
                        imageQueueArrayList[mCurrentImageIndex].uriPath
                    )
                    intent.putExtra(IMAGE_QUEUE_LIST, imageQueueArrayList)
                    setResult(CROP_IMAGE_RESULT, intent)
                    finish()
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }
            }
        }
        cropScreenBinding.cLRotate.setOnClickListener {
            if (disableClick()) {
                angle += 90
                cropScreenBinding.cropView.rotatedDegrees = angle
            }
        }
        cropScreenBinding.cLFitImage.setOnClickListener {
            if (disableClick()) {
                cropScreenBinding.cropView.setImageBitmap(rotatedBitmap)
            }
        }
    }


    override fun onBackPressed() {

        showConfirmationDialog(this@CropScreen, supportFragmentManager) { activity ->
            activity.finish()
            activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
    }
}