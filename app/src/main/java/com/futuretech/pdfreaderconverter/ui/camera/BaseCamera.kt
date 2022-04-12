package com.futuretech.pdfreaderconverter.ui.camera

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.view.ScaleGestureDetector
import android.view.View
import android.view.ViewTreeObserver
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.futuretech.pdfreaderconverter.data.viewmodel.FileViewModel
import com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel
import com.futuretech.pdfreaderconverter.databinding.ActivityCameraScreenBinding
import com.futuretech.pdfreaderconverter.model.ImageQueue
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.TimeUnit
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

open class BaseCamera : AppCompatActivity() {

    protected val cameraBinding: ActivityCameraScreenBinding by lazy {

        ActivityCameraScreenBinding.inflate(layoutInflater)
    }
    val fileViewModel: FileViewModel by viewModels()
    val imageQueueViewModel: ImageQueueViewModel by viewModels()
    var imageQueueObj: ImageQueue? = null
    protected var imageQueueArrayList = ArrayList<ImageQueue>()

    protected var uri: Uri? = null

    companion object {
        const val TAG = "CameraX"
    }

    protected var hasBatchMode: Boolean = false
    protected var hasGridMode: Boolean = false
    protected var hasFlashMode: Boolean = false
    protected var camera: Camera? = null
    protected lateinit var uris: List<Uri>
    protected var imageAnalyzer: ImageAnalysis? = null
    protected var lensFacing = CameraSelector.LENS_FACING_BACK
    protected var previewBuilder: Preview.Builder? = null
    protected var preview: Preview? = null
    protected var imageCaptureBuilder: ImageCapture.Builder? = null
    protected var captureCounter: Int = 0

    protected val filename = "yyyy-MM-dd-HH-mm-ss-SSS"
    protected val photoExtension = ".jpg"
    private val ratioValue1 = 4.0 / 3.0
    private val ratioValue2 = 16.0 / 9.0

    /** Blocking camera operations are performed using this executor */
    protected lateinit var cameraExecutor: ExecutorService
    protected var imageCapture: ImageCapture? = null
    protected lateinit var outputDirectory: File

    protected fun createFile(baseFolder: File, format: String, extension: String) = File(
        baseFolder,
        SimpleDateFormat(format, Locale.US).format(System.currentTimeMillis()) + extension
    )

    protected fun setGalleryThumbnail(uri: Uri) {

        cameraBinding.iVThumbnail.post {

            Glide.with(this)
                .load(uri)
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(cameraBinding.iVThumbnail)
        }

        cameraBinding.tvBadgeIcon.post {
            cameraBinding.tvBadgeIcon.text = "${++captureCounter}"
        }
    }

    protected fun aspectRatio(width: Int, height: Int): Int {
        val previewRatio = max(width, height).toDouble() / min(width, height)
        return if (abs(previewRatio - ratioValue1) <= abs(previewRatio - ratioValue2)) AspectRatio.RATIO_4_3
        else AspectRatio.RATIO_16_9
    }

    protected fun hideBackArrowThumbnailWidget() {
        cameraBinding.cLImportFromGallery.visibility = View.VISIBLE
        cameraBinding.cLBatchMode.visibility = View.VISIBLE
        cameraBinding.cLBackStartCamera.visibility = View.INVISIBLE
        cameraBinding.cLThumbnail.visibility = View.INVISIBLE

    }

    protected fun showBackArrowThumbnailWidget() {

        cameraBinding.cLImportFromGallery.visibility = View.INVISIBLE
        cameraBinding.cLBatchMode.visibility = View.INVISIBLE
        cameraBinding.cLBackStartCamera.visibility = View.VISIBLE
        cameraBinding.cLThumbnail.visibility = View.VISIBLE

    }

    @SuppressLint("LogNotTimber")
    protected fun enableFocusFeature() {
        cameraBinding.cameraPreview.afterMeasured {
            val autoFocusPoint = SurfaceOrientedMeteringPointFactory(1f, 1f)
                .createPoint(.5f, .5f)
            try {
                val autoFocusAction = FocusMeteringAction.Builder(
                    autoFocusPoint,
                    FocusMeteringAction.FLAG_AF
                ).apply {
                    //start auto-focusing after 2 seconds
                    setAutoCancelDuration(2, TimeUnit.SECONDS)
                }.build()
                camera?.cameraControl?.startFocusAndMetering(autoFocusAction)
            } catch (e: CameraInfoUnavailableException) {
                Log.d("ERROR", "cannot access camera", e)
            }
        }
    }

    private inline fun View.afterMeasured(crossinline block: () -> Unit) {
        viewTreeObserver.addOnGlobalLayoutListener(object :
            ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                if (measuredWidth > 0 && measuredHeight > 0) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this)
                    block()
                }
            }
        })
    }

    @SuppressLint("ClickableViewAccessibility")
    protected fun enableZoomFeature() {
        val listener = object : ScaleGestureDetector.SimpleOnScaleGestureListener() {
            override fun onScale(detector: ScaleGestureDetector): Boolean {
                val currentZoomRatio: Float = camera?.cameraInfo?.zoomState?.value?.zoomRatio ?: 0F
                val delta = detector.scaleFactor
                camera?.cameraControl?.setZoomRatio(currentZoomRatio * delta)
                return true
            }
        }
        val scaleGestureDetector = ScaleGestureDetector(this, listener)

        cameraBinding.cameraPreview.setOnTouchListener { _, event ->
            scaleGestureDetector.onTouchEvent(event)
            return@setOnTouchListener true
        }
    }


}