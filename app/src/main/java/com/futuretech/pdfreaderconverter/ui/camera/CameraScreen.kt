package com.futuretech.pdfreaderconverter.ui.camera

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.Configuration
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.*
import android.provider.Settings
import android.util.DisplayMetrics
import android.util.Log
import android.util.Size
import android.view.View
import android.webkit.MimeTypeMap
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.core.net.toFile
import androidx.lifecycle.lifecycleScope
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen
import com.futuretech.pdfreaderconverter.ui.gallery.GalleryScreen
import com.futuretech.pdfreaderconverter.utility.Constants
import com.futuretech.pdfreaderconverter.utility.Constants.GALLERY_IMAGE
import com.futuretech.pdfreaderconverter.utility.Constants.GALLERY_PICKER_RESULT
import com.futuretech.pdfreaderconverter.utility.Constants.IMAGE_QUEUE_LIST
import com.futuretech.pdfreaderconverter.utility.FileOperation.getOutputFileDirectory
import com.futuretech.pdfreaderconverter.utility.FileOperation.getRealPathFromURI
import com.futuretech.pdfreaderconverter.utility.Logger
import com.futuretech.pdfreaderconverter.utility.LuminosityAnalyzer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import java.io.File
import java.util.concurrent.Executors

class CameraScreen : BaseCamera(), EasyPermissions.PermissionCallbacks,
    EasyPermissions.RationaleCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(cameraBinding.root)

        cameraExecutor = Executors.newSingleThreadExecutor()
        setToolbar()
        setListener()

        if (hasCameraPermission()) {
            startCamera()
            cameraBinding.cameraPreview.post {
                updateCameraUi()
                bindCameraUseCases()
            }
        } else {
            EasyPermissions.requestPermissions(
                this,
                getString(R.string.rationale_camera),
                Constants.RC_CAMERA_PERM,
                Manifest.permission.CAMERA
            )
        }
        outputDirectory =
            getOutputFileDirectory(resources.getString(R.string.app_name))

    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(cameraBinding.cameraPreview.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()
                camera = cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview
                )
                enableZoomFeature()
                enableFocusFeature()
            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(this))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        updateCameraUi()
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private fun updateCameraUi() {
        cameraBinding.iVCapture.setOnClickListener {
            if (hasCameraPermission()) {

//                    val sound = MediaActionSound()
//                    sound.play(MediaActionSound.SHUTTER_CLICK)
                val scanningDialog =
                    showLoadingDialog(
                        supportFragmentManager,
                        getString(R.string.processing)
                    )

                imageCapture?.let { imageCapture ->
                    val photoFile = createFile(
                        outputDirectory,
                        filename,
                        photoExtension
                    )
                    val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile)
                        .build()

                    imageCapture.takePicture(
                        outputOptions,
                        cameraExecutor,
                        object : ImageCapture.OnImageSavedCallback {

                            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                                if (scanningDialog.isVisible) {
                                    scanningDialog.dismiss()
                                }
                                val savedUri = output.savedUri ?: Uri.fromFile(photoFile)
                                uri = savedUri

                                setImageQueueData(getRealPathFromURI(savedUri))
                                setGalleryThumbnail(savedUri)

                                val mimeType = MimeTypeMap.getSingleton()
                                    .getMimeTypeFromExtension(savedUri.toFile().extension)
                                MediaScannerConnection.scanFile(
                                    applicationContext,
                                    arrayOf(savedUri.toString()),
                                    arrayOf(mimeType)
                                ) { _, uri ->

                                }

                                if (!hasBatchMode) {
                                    startEditImageScreen()
                                }
                            }

                            override fun onError(exception: ImageCaptureException) {
                                if (scanningDialog!!.isVisible) {
                                    scanningDialog.dismiss()
                                }
                            }
                        })
                }
            } else {
                EasyPermissions.requestPermissions(
                    this,
                    getString(R.string.rationale_camera),
                    Constants.RC_CAMERA_PERM,
                    Manifest.permission.CAMERA
                )
            }
//            }

            if (!hasBatchMode) {
                hideBackArrowThumbnailWidget()
            } else {
                showBackArrowThumbnailWidget()
            }
        }
    }

    private fun startEditImageScreen() {
        deleteQueueImage()
        val intent = Intent(this@CameraScreen, EditImageScreen::class.java)
        val tempQueueArrayList = ArrayList<ImageQueue>()
        tempQueueArrayList.addAll(imageQueueArrayList)
        imageQueueArrayList.clear()
        tempQueueArrayList.reverse()
        intent.putExtra(IMAGE_QUEUE_LIST, tempQueueArrayList)
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
        clearListValues()
        hasBatchMode = true
    }

    private fun clearListValues() {
        imageQueueArrayList.remove(imageQueueObj)
        imageQueueArrayList = ArrayList()
        deleteQueueImage()
        captureCounter = 0
        Handler(Looper.getMainLooper()).post {
            cameraBinding.tvBadgeIcon.text = ""
        }
        hideBackArrowThumbnailWidget()
    }

    private fun bindCameraUseCases() {

        val metrics =
            DisplayMetrics().also { cameraBinding.cameraPreview.display.getRealMetrics(it) }

        val screenAspectRatio = aspectRatio(metrics.widthPixels, metrics.heightPixels)

        val rotation = cameraBinding.cameraPreview.rotation.toInt()

        val cameraSelector = CameraSelector.Builder().requireLensFacing(lensFacing).build()
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({

            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            previewBuilder = Preview.Builder()
                .setTargetAspectRatio(screenAspectRatio)
                .setTargetRotation(rotation)

            preview = previewBuilder?.build()

            preview?.setSurfaceProvider(cameraBinding.cameraPreview.surfaceProvider)

            imageCaptureBuilder = ImageCapture.Builder()
                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
                .setTargetAspectRatio(screenAspectRatio)
                .setTargetRotation(rotation)

            imageCapture = imageCaptureBuilder?.build()
            imageAnalyzer = ImageAnalysis.Builder()
                .setTargetResolution(Size(720, 1280))
//                .setTargetAspectRatio(screenAspectRatio)
                .setTargetRotation(rotation)
                .build()
                .also {
                    it.setAnalyzer(cameraExecutor, LuminosityAnalyzer { luma ->
                    })
                }
            cameraProvider.unbindAll()

            try {

                camera = cameraProvider.bindToLifecycle(
                    this,
                    cameraSelector,
                    preview,
                    imageCapture
                )

            } catch (exception: Exception) {

            }
        }, ContextCompat.getMainExecutor(this))

    }

    override fun onResume() {
        hasFlashMode = true
        setFlash()
        super.onResume()
    }

    private fun setFlash() {

        if (!hasFlashMode) {
//            setFlashMode(true)
            hasFlashMode = true
            cameraBinding.toolbar.iVFlashMode.setImageResource(R.drawable.ic_flash_on)
            camera?.cameraControl?.enableTorch(hasFlashMode)
        } else {
//            setFlashMode(false)
            hasFlashMode = false
            cameraBinding.toolbar.iVFlashMode.setImageResource(R.drawable.ic_flash_off)
            camera?.cameraControl?.enableTorch(hasFlashMode)
        }
    }

    private fun deleteQueueImage() {

        lifecycleScope.launch(Dispatchers.IO) {

            imageQueueViewModel.deleteAllQueueImages()
        }
    }

    private fun setImageQueueData(path: String?) {

        imageQueueObj = ImageQueue(path)
        imageQueueArrayList.add(
            imageQueueObj!!
        )
        lifecycleScope.launch(Dispatchers.Main) {
            imageQueueViewModel.insertQueueImage(imageQueueObj!!)
        }
    }

    private fun requestGalleryPermission() {
        EasyPermissions.requestPermissions(
            this,
            getString(R.string.rationale_camera),
            Constants.RC_GALLERY_PERM,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    private fun setListener() {
        cameraBinding.toolbar.iVBackArrow.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        }
        cameraBinding.toolbar.iVFlashMode.setOnClickListener {
            if (disableClick()) {
                setFlash()
            }
        }
        cameraBinding.cLThumbnail.setOnClickListener {
            if (disableClick()) {
                startEditImageScreen()
            }
        }
        cameraBinding.cLBatchMode.setOnClickListener {

            if (!hasBatchMode) {
                hasBatchMode = true
                cameraBinding.iVBatchMode.setColorFilter(
                    ContextCompat.getColor(this, R.color.colorPrimary),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )
                cameraBinding.tvBatchMode.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.colorPrimary
                    )
                )
                showToast(getString(R.string.batch_mode_enable))
            } else {
                hasBatchMode = false
                cameraBinding.iVBatchMode.setColorFilter(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    ), android.graphics.PorterDuff.Mode.SRC_IN
                )
                cameraBinding.tvBatchMode.setTextColor(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
                showToast(getString(R.string.single_mode_enable))
            }
        }
        cameraBinding.cLBackStartCamera.setOnClickListener {
            if (disableClick()) {

                it.post {
                    clearListValues()
                }
            }
        }
        cameraBinding.cLImportFromGallery.setOnClickListener { view ->
            if (disableClick()) {
                if (!hasStoragePermission()) {
                    requestGalleryPermission()
                } else {
                    startGalleryScreen()
                }
            }
        }
    }

    private fun startGalleryScreen() {
        val intent = Intent(this, GalleryScreen::class.java)
        galleryLauncher.launch(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    @SuppressLint("SetTextI18n")
    private fun setToolbar() {
        cameraBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        cameraBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        cameraBinding.toolbar.tvToolbarTitle.text = "Camera"
        cameraBinding.toolbar.iVFlashMode.visibility = View.VISIBLE
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {

            Constants.RC_CAMERA_PERM -> {

                startCamera()
                cameraBinding.cameraPreview.post {
                    updateCameraUi()
                    bindCameraUseCases()
                }
            }
            Constants.RC_GALLERY_PERM -> {
                // move to gallery selector fragment
//                findNavController().navigate()
            }
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }

    override fun onRationaleAccepted(requestCode: Int) {

    }

    override fun onRationaleDenied(requestCode: Int) {

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            Logger.debug("requestCode_new", requestCode.toString())
        }
    }

    @SuppressLint("LogNotTimber")
    var galleryLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {

        if (it.resultCode == GALLERY_PICKER_RESULT) {
            val intent: Intent? = it.data
            if (intent != null) {
                val uriImagesList = intent.getSerializableExtra(
                    GALLERY_IMAGE
                )
                Log.d("ImagesList::", "setupListeners: images -> $uriImagesList")
                val outputDirectory = getOutputFileDirectory(resources.getString(R.string.app_name))
                Logger.debug("DIRECTORY", outputDirectory.toString())
                for ((i, element) in (uriImagesList as ArrayList<*>).withIndex()) {
                    val srcFile = File(getRealPathFromURI(element as Uri))
                    val destFile =
                        File(
                            outputDirectory,
                            getCurrentTimeStamp() + i.toString() + srcFile.name
                        )

                    if (srcFile.exists()) {
                        srcFile.copyTo(
                            target = destFile,
                            overwrite = true,
                            bufferSize = DEFAULT_BUFFER_SIZE
                        )
                    }
                    setImageQueueData(destFile.absolutePath)
                }

                startEditImageScreen()
            }
        }
    }
}