package com.futuretech.pdfreaderconverter.ui.pdfFiles

import android.annotation.SuppressLint
import android.content.ContentUris
import android.content.Intent
import android.database.ContentObserver
import android.database.Cursor
import android.database.StaleDataException
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.adapter.PdfFilesAdapter
import com.futuretech.pdfreaderconverter.databinding.FragmentPdfFilesBinding
import com.futuretech.pdfreaderconverter.dialog.FileOperationDialog
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.PdfFile
import com.futuretech.pdfreaderconverter.ui.base.BaseFragment
import com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_DELETE
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_OPEN
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_RENAME
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SEARCH
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SHARE
import com.futuretech.pdfreaderconverter.utility.Constants.PDF_FILE_ARRAY_LIST
import com.futuretech.pdfreaderconverter.utility.Constants.PDF_FILE_FRAGMENT
import com.futuretech.pdfreaderconverter.utility.Constants.PDF_FILE_OBJECT
import kotlinx.coroutines.*

class PdfFilesFragment : BaseFragment() {

    private lateinit var mBinding: FragmentPdfFilesBinding
    private var job = Job()
    val scope = CoroutineScope(Dispatchers.Main + job)
    private var path: String? = null
    private var pdfFileArrayList: ArrayList<PdfFile> = ArrayList()
    private var fileOperationDialog: FileOperationDialog? = null
    private var selectionMimeType: String? = null
    private var selectionArgs: Array<String>? = null
    private var pdf: String? = MimeTypeMap.getSingleton().getMimeTypeFromExtension("pdf")
    private var allFileCursor: Cursor? = null
    private val pdfFileViewModel: PdfFilesViewModel by viewModels()
    private val uri = if (hasSdkHigherThan(Build.VERSION_CODES.R))
        MediaStore.Files.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY)
    else
        MediaStore.Files.getContentUri("external")
    private val projection: Array<String>? = null
    private val sortOrder = "${MediaStore.Files.FileColumns.DATE_MODIFIED} DESC"
    private var idCol = 0
    private var mimeCol: Int = 0
    private var addedCol = 0
    private var titleCol = 0
    private var nameCol = 0
    private var sizeCol = 0
    private var uriFile: Uri? = null
    var id: Int? = null
    private var mimeType: String? = null
    private var size: String? = null
    private var title: String? = null
    private var dateAdded: Long = 0

    private val pdfFilesAdapter: PdfFilesAdapter by lazy {
        PdfFilesAdapter(
            fun(clickItem: PdfFile, action: Int, pos: Int) {
                handleClickAction(clickItem, action, pos)
            }, fun(documentFileArrayList: List<PdfFile>?, action: Int) {
                handleSearchAction(documentFileArrayList, action)
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_pdf_files, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pdfFileViewModel.actions.observe(viewLifecycleOwner) {
            loadPdfFiles()
        }
        setToolbar()
        setListener()
    }

    private fun setToolbar() {
        mBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        mBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        mBinding.toolbar.iVSearch.visibility = View.VISIBLE
        mBinding.toolbar.tvToolbarTitle.setText(R.string.title)
    }

    private fun setListener() {

        mBinding.toolbar.iVBackArrow.setOnClickListener {

            navigate(R.id.action_pdfFilesFragment_to_rootFragment)
        }
        mBinding.toolbar.iVSearch.setOnClickListener {
            if (disableClick()) {
                mBinding.toolbar.toolbar.visibility = View.INVISIBLE
                mBinding.searchBar.cLSearchBar.visibility = View.VISIBLE
                setTextChangeListener()
            }
        }
        mBinding.searchBar.iVBackArrow.setOnClickListener {
            if (disableClick()) {
                clearSearchBar()
                requireActivity().hideKeyboard(it)
            }
        }
    }

    private fun setTextChangeListener() {
        openKeyboard()
        setDocumentTextWatcher()
    }

    private var contentObserver: ContentObserver? = null

    private fun loadPdfFiles() {
        if (requireContext().hasStoragePermission()) {
            getPdfFiles()
            if (contentObserver == null) {
                contentObserver =
                    requireContext().applicationContext.contentResolver.registerObserver(uri) {
                        getPdfFiles()
                    }
            }
        }
    }

    private fun getPdfFiles(/*callBack: () -> Unit*/) {
        pdfFileArrayList = ArrayList()
        selectionMimeType = MediaStore.Files.FileColumns.MIME_TYPE + "=?"
        selectionArgs = arrayOf(pdf.toString())
        allFileCursor = requireContext().contentResolver
            .query(uri, projection, selectionMimeType, selectionArgs, sortOrder)
        idCol = allFileCursor?.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID)!!
        mimeCol = allFileCursor?.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE)!!
        addedCol =
            allFileCursor?.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATE_MODIFIED)!!
        titleCol = allFileCursor?.getColumnIndexOrThrow(MediaStore.Files.FileColumns.TITLE)!!
        nameCol = allFileCursor?.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME)!!
        sizeCol = allFileCursor?.getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE)!!

        try {
            if (allFileCursor != null) {
                if (allFileCursor!!.count >= 0) {
                    if (allFileCursor!!.moveToFirst()) {
                        do {
                            id = allFileCursor?.getInt(idCol)
                            mimeType = allFileCursor?.getString(mimeCol)
                            title = allFileCursor?.getString(titleCol)
                            size = allFileCursor?.getString(sizeCol)
                            dateAdded = allFileCursor?.getLong(addedCol)!!
                            uriFile = ContentUris.withAppendedId(uri, id?.toLong()!!)
                            val pathCol =
                                allFileCursor!!.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA)
                            path = allFileCursor?.getString(pathCol)
//                            val filename : String= allFileCursor?.getString(nameCol) ?: allFileCursor?.getString(titleCol) ?: ""
                            pdfFileArrayList.add(
                                PdfFile(
                                    id!!,
                                    title.toString(),
                                    mimeType!!,
                                    dateAdded,
                                    size.toString(),
                                    uriFile,
                                    path!!
                                )
                            )
                        } while (allFileCursor?.moveToNext()!!)
                    }
                }
                allFileCursor?.close()
                try {
                    setDocumentFilesAdapter()

                } catch (e: IllegalStateException) {
                    e.printStackTrace()
                }
                setDocumentTextWatcher()
            }
        } catch (e: StaleDataException) {
            e.printStackTrace()
        } finally {
            allFileCursor!!.close()
        }
    }

    override fun onDestroy() {
        contentObserver?.let {
            requireActivity().application.contentResolver.unregisterContentObserver(contentObserver!!)
        }
        super.onDestroy()
    }

    private fun setDocumentFilesAdapter() {

        if (pdfFileArrayList.size == 0) {
            pdfFilesAdapter.submitList(pdfFileArrayList)
        } else {
            val layoutManager = LinearLayoutManager(requireContext())
            mBinding.rvPdfFilesList.layoutManager = layoutManager
            mBinding.rvPdfFilesList.itemAnimator = DefaultItemAnimator()
            mBinding.rvPdfFilesList.adapter = pdfFilesAdapter
            pdfFilesAdapter.setAdapterList(pdfFileArrayList)
            pdfFilesAdapter.submitList(pdfFileArrayList)
        }
    }

    private fun setDocumentTextWatcher() {
        mBinding.searchBar.edtName.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int,
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int,
            ) {
                if (pdfFileArrayList.size > 0) {
                    pdfFilesAdapter.filter.filter(s)
                }
            }
        })
    }

    private fun openKeyboard() {
        mBinding.searchBar.edtName.postDelayed({
            mBinding.searchBar.edtName.requestFocus()
            requireActivity().showKeyboard()
        }, 100)
    }

    private fun clearSearchBar() {
        requireActivity().hideKeyboard(mBinding.root)
        mBinding.toolbar.toolbar.visibility = View.VISIBLE
        mBinding.searchBar.cLSearchBar.visibility = View.INVISIBLE
        mBinding.searchBar.edtName.text.clear()
    }

    private fun startPdfViewerActivity(clickItem: PdfFile) {
        val intent = Intent(requireContext(), PdfFileViewerActivity::class.java)
        intent.putExtra(PDF_FILE_OBJECT, clickItem)
        intent.putExtra(PDF_FILE_ARRAY_LIST, pdfFileArrayList)
        intent.putExtra(PDF_FILE_FRAGMENT, true)
        startActivity(intent)
        requireActivity().overridePendingTransition(
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
    }

    private fun handleClickAction(clickItem: PdfFile, action: Int, pos: Int) {
        clearSearchBar()
        when (action) {

            ACTION_OPEN -> {
                startPdfViewerActivity(clickItem)
            }
            ACTION_SHARE -> {
                if (clickItem.uri != null) {
                    val share = Intent()
                    share.action = Intent.ACTION_SEND
                    share.type = clickItem.mimeType
                    share.putExtra(Intent.EXTRA_STREAM, clickItem.uri)
                    share.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                    share.flags = Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                    startActivity(Intent.createChooser(share, "Share it"))
                }
            }
            ACTION_DELETE -> {
                showFileOperationDialog(clickItem, action, pos)
            }
            ACTION_RENAME -> {
                showFileOperationDialog(clickItem, action, pos)
            }

        }
    }

    private fun showFileOperationDialog(
        clickItem: PdfFile,
        action: Int,
        pos: Int,
    ) {
        fileOperationDialog =
            FileOperationDialog(clickItem,
                action,
                fun(clickItem: Any, action: Int, b: Boolean) {
                    handleDeleteRenameAction(clickItem, action, b, pos)
                })
        fileOperationDialog?.isCancelable = false
        fileOperationDialog?.show(
            parentFragmentManager,
            FileOperationDialog.TAG
        )
    }

    private fun handleSearchAction(pdfFileArrayList: List<PdfFile>?, action: Int) {

        when (action) {

            ACTION_SEARCH -> {

                val edtLength =
                    mBinding.searchBar.edtName.text.trim().length

                if (edtLength == 0 && pdfFileArrayList?.size == 0) {
                    mBinding.rvPdfFilesList.visibility = View.GONE
                    mBinding.cLNoSearchItem.visibility = View.GONE
                    return
                } else if (pdfFileArrayList?.size == 0) {
                    mBinding.cLNoSearchItem.visibility = View.VISIBLE
                } else if (edtLength > 1 && pdfFileArrayList?.size == 0) {
                    mBinding.rvPdfFilesList.visibility = View.GONE
                    mBinding.cLNoSearchItem.visibility = View.VISIBLE

                } else if (pdfFileArrayList?.size!! > 0) {
                    mBinding.rvPdfFilesList.visibility = View.VISIBLE
                    mBinding.cLNoSearchItem.visibility = View.GONE
                } else {
                    mBinding.cLNoSearchItem.visibility = View.GONE

                }

            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun handleDeleteRenameAction(clickItem: Any, action: Int, b: Boolean, pos: Int) {

        when (action) {

            ACTION_DELETE -> {
                if (clickItem is PdfFile) {

                    val loadingDialog =
                        context?.showLoadingDialog(parentFragmentManager,
                            getString(R.string.deleting))
                    scope.launch {
                        scope.async(Dispatchers.IO) {
                            pdfFileViewModel.deleteFile(clickItem)
                        }.await()
//                        documentFilesAdapter.notifyItemChanged(pos)
                        loadingDialog?.dismiss()
                    }

                }
            }
            ACTION_RENAME -> {
                val edtName =
                    fileOperationDialog?.fileOperationDialogBinding?.edtName?.text.toString()
                        .trim()
                if (clickItem is PdfFile) {
                    for (documentFile in pdfFileArrayList) {
                        if (documentFile.name.lowercase().trim() == edtName) {
                            requireContext().showToast(resources.getString(R.string.file_already_exist))
                            return
                        }
                    }
                    scope.launch {
                        val loadingDialog =
                            context?.showLoadingDialog(parentFragmentManager,
                                getString(R.string.rename))
                        scope.async(Dispatchers.IO) {
                            pdfFileViewModel.renameFile(clickItem, edtName)
                        }.await()
                        loadingDialog?.dismiss()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadPdfFiles()
    }

    override fun onPause() {
        super.onPause()
        clearSearchBar()
    }


}