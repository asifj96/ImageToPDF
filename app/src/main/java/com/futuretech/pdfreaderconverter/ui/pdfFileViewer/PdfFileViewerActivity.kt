package com.futuretech.pdfreaderconverter.ui.pdfFileViewer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.ActivityPdfFileViewerBinding
import com.futuretech.pdfreaderconverter.dialog.PdfPasswordDialog
import com.futuretech.pdfreaderconverter.extension.disableClick
import com.futuretech.pdfreaderconverter.extension.showToast
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.PdfFile
import com.futuretech.pdfreaderconverter.ui.base.BaseActivity
import com.futuretech.pdfreaderconverter.ui.pdfFiles.PdfFilesViewModel
import com.futuretech.pdfreaderconverter.utility.Constants.FILE_MODEL_OBJ
import com.futuretech.pdfreaderconverter.utility.Constants.FILE_PATH
import com.futuretech.pdfreaderconverter.utility.Constants.FILE_URI
import com.futuretech.pdfreaderconverter.utility.Constants.PDF_FILE_ARRAY_LIST
import com.futuretech.pdfreaderconverter.utility.Constants.PDF_FILE_FRAGMENT
import com.futuretech.pdfreaderconverter.utility.Constants.PDF_FILE_OBJECT
import com.futuretech.pdfreaderconverter.utility.Logger
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener
import com.github.barteksc.pdfviewer.listener.OnRenderListener
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.shockwave.pdfium.PdfPasswordException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.io.File

class PdfFileViewerActivity : BaseActivity(), OnPageChangeListener, OnPageErrorListener,
    OnLoadCompleteListener, OnRenderListener {

    private var isOutsideApp: Boolean = false
    private var pdfFileArrayList: ArrayList<PdfFile> = ArrayList()
    private var filePath: String? = ""
    private var pdfName = ""
    private var edtPass: String = ""
    private var uri: Uri? = null
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private var isSwipe: Boolean? = false
    private var isNightMode: Boolean? = false
    var currentPage: Int = 0
    private val pdfFilesViewModel: PdfFilesViewModel by viewModels()
    private lateinit var outputDirectory: File
    private lateinit var fileModelObj: FileModel
    private lateinit var fileObj: Any
    private var job = Job()
    val scope = CoroutineScope(Dispatchers.Main + job)
    private var isInitialRender: Boolean = false

    private val mBinding: ActivityPdfFileViewerBinding by lazy {

        ActivityPdfFileViewerBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)

        if (intent.data != null) {
            uri = intent.data
            isOutsideApp = true
            val docFile = File(uri?.path!!)
            pdfName = docFile.nameWithoutExtension
        } else {
            if (getPdfFragment()) {
                uri = getPdfFileObj()?.uri
                fileObj = getPdfFileObj()!!
                filePath = getPdfFileObj()!!.path
                pdfFileArrayList =
                    intent.getParcelableArrayListExtra<PdfFile>(PDF_FILE_ARRAY_LIST) as ArrayList<PdfFile>
            } else {
                uri = getFileUri()!!
                fileModelObj = getFileModelObj()!!
                fileObj = getFileModelObj()!!
                filePath = getFilePath()
            }
        }

        setToolbar()
        loadPdfFile()
        setListener()
    }

    private fun setListener() {

        mBinding.toolbar.iVBackArrow.setOnClickListener {
            if (disableClick()) {
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }
        }
        mBinding.toolbar.iVShare.setOnClickListener {

            val shareIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_STREAM, uri)
                type = "application/pdf"
            }
            startActivity(Intent.createChooser(shareIntent, pdfName))

        }
    }



    private fun getPdfFileObj(): PdfFile? {
        return intent.getParcelableExtra(PDF_FILE_OBJECT)
    }

    private fun getFilePath(): String? {
        return intent.getStringExtra(FILE_PATH)
    }

    private fun getFileModelObj(): FileModel? {
        return intent.getParcelableExtra(FILE_MODEL_OBJ)
    }

    private fun getPdfFragment(): Boolean {
        return intent.getBooleanExtra(PDF_FILE_FRAGMENT, false)
    }

    private fun getFileUri(): Uri? {
        return intent.getParcelableExtra(FILE_URI)
    }

    private fun setToolbar() {
        if (isOutsideApp) {
            mBinding.toolbar.iVShare.visibility = View.VISIBLE
            mBinding.toolbar.tvToolbarTitle.text = pdfName
        } else {
            if (getPdfFragment()) {
                mBinding.toolbar.tvToolbarTitle.text = getPdfFileObj()?.name
            } else {
                mBinding.toolbar.tvToolbarTitle.text = getFileModelObj()?.title
            }
        }
        mBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        mBinding.toolbar.tvToolbarTitle.isSelected = true
        mBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        mBinding.toolbar.iVShare.visibility = View.VISIBLE
    }

    private fun loadPdfFile() {

        if (isOutsideApp) {
            mBinding.pdfViewer.fromUri(uri)
                .onError {
                    if (it is PdfPasswordException) {

                        Logger.debug("LOAD_PDFVIEWER_ERROR=>", it.message)

                        showPdfPasswordDialog()
                    }
                }
                .defaultPage(currentPage)
                .onPageChange(this)
                .enableAntialiasing(true)
                .enableAnnotationRendering(true)
                .autoSpacing(true)
                .enableSwipe(true)
                .swipeHorizontal(isSwipe!!)
                .nightMode(isNightMode!!)
                .pageFling(true)
                .fitEachPage(true)
                .pageSnap(true)
                .onLoad(this)
                .onPageError(this)
                .onRender(this)
                .load()
        } else {
            mBinding.pdfViewer.fromFile(File(filePath!!))
                .onError {
                    if (it is PdfPasswordException) {

                        Logger.debug("LOAD_PDF_ERROR=>", it.message)

                        showPdfPasswordDialog()
                    }
                }
                .defaultPage(currentPage)
                .onPageChange(this)
                .enableAntialiasing(true)
                .enableAnnotationRendering(true)
                .autoSpacing(true)
                .enableSwipe(true)
                .swipeHorizontal(isSwipe!!)
                .nightMode(isNightMode!!)
                .pageFling(true)
                .fitEachPage(true)
                .pageSnap(true)
                .onLoad(this)
                .onPageError(this)
                .onRender(this)
                .load()
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onPageChanged(page: Int, pageCount: Int) {
        mBinding.tvPdfPage.text = String.format("%s / %s", page + 1, pageCount)
        currentPage = page
    }

    override fun onPageError(page: Int, t: Throwable?) {
        Logger.debug("ONError::", "$t")

    }

    override fun loadComplete(nbPages: Int) {
        Logger.debug("ONLOADCOmplete::", "$nbPages")
    }


    override fun onInitiallyRendered(nbPages: Int) {
        Logger.debug("ONRenderCOmplete::", "$nbPages")
        if (!isInitialRender) {
            isInitialRender = true
        }
        Logger.debug("isInitialRender::", "$isInitialRender")

    }


    private var pdfPasswordDialog: PdfPasswordDialog? = null

    private fun showPdfPasswordDialog() {
        pdfPasswordDialog =
            PdfPasswordDialog(fun(password: String) {

                reloadPDF(password, uri)
            })
        pdfPasswordDialog?.setData(this@PdfFileViewerActivity)
        pdfPasswordDialog?.isCancelable = false
        pdfPasswordDialog?.show(
            supportFragmentManager,
            PdfPasswordDialog.TAG
        )
    }

    private fun reloadPDF(password: String, uri: Uri?) {
        edtPass = password
        mBinding.pdfViewer.fromUri(uri)
            .onError { t ->
                if (t is PdfPasswordException) {
                    showToast(resources.getString(R.string.incorrect_password))
                    showPdfPasswordDialog()
                }
            }
            .password(password)
            .defaultPage(currentPage)
            .onPageChange(this)
            .enableAntialiasing(true)
            .enableAnnotationRendering(true)
            .autoSpacing(true)
            .enableSwipe(true)
            .swipeHorizontal(isSwipe!!)
            .nightMode(isNightMode!!)
            .pageFling(true)
            .fitEachPage(true)
            .pageSnap(true)
            .onLoad(this)
            .onPageError(this)
            .onRender(this)
            .load()
    }

}