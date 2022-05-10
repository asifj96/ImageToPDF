package com.futuretech.pdfreaderconverter.ui.home

import android.content.Context
import android.content.Intent
import android.media.MediaScannerConnection
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.whenCreated
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.adapter.HomeFilesAdapter
import com.futuretech.pdfreaderconverter.databinding.ActivityHomeFilesBinding
import com.futuretech.pdfreaderconverter.dialog.HomeItemDialog
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.ui.base.BaseActivity
import com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_DELETE
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_OPEN
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_RENAME
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SEARCH
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_SHARE
import com.futuretech.pdfreaderconverter.utility.Constants.FILE_MODEL_OBJ
import com.futuretech.pdfreaderconverter.utility.Constants.FILE_PATH
import com.futuretech.pdfreaderconverter.utility.Constants.FILE_URI
import com.futuretech.pdfreaderconverter.utility.FileOperation.getOutputFileDirectory
import com.futuretech.pdfreaderconverter.utility.FileOperation.getUriPath
import com.futuretech.pdfreaderconverter.utility.Logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File

class HomeFiles : BaseActivity() {

    private lateinit var homeItemDialog: HomeItemDialog
    private var fileModelArrayList: ArrayList<FileModel> = ArrayList()

    private val homeFilesBinding: ActivityHomeFilesBinding by lazy {

        ActivityHomeFilesBinding.inflate(layoutInflater).apply {

            rvHomeFilesList.layoutManager =
                LinearLayoutManager(this@HomeFiles, RecyclerView.VERTICAL, false)
            rvHomeFilesList.setHasFixedSize(true)
            rvHomeFilesList.adapter = homeFilesAdapter
        }
    }
    private val homeFilesAdapter: HomeFilesAdapter by lazy {
        HomeFilesAdapter(
            fun(clickItem: FileModel, action: Int) {
                clickAction(clickItem, action)
            }, fun(homeFileArrayList: List<FileModel>?, action: Int) {
                searchAction(homeFileArrayList, action)
            })
    }


    private fun searchAction(searchFileArrayList: List<FileModel>?, action: Int) {

        when (action) {

            ACTION_SEARCH -> {

                val edtLength =
                    homeFilesBinding.searchBar.edtName.text.trim().length

                if (edtLength == 0 && fileModelArrayList.size == 0) {
                    homeFilesBinding.rvHomeFilesList.visibility = View.GONE
                    homeFilesBinding.cLNoSearchItem.visibility = View.GONE
                    return
                } else if (searchFileArrayList?.size == 0) {
                    homeFilesBinding.cLNoSearchItem.visibility = View.VISIBLE

                } else if (edtLength > 1 && searchFileArrayList?.size == 0) {
                    homeFilesBinding.rvHomeFilesList.visibility = View.GONE
                    homeFilesBinding.cLNoSearchItem.visibility = View.VISIBLE

                } else if (fileModelArrayList.size > 0) {
                    homeFilesBinding.rvHomeFilesList.visibility = View.VISIBLE
                    homeFilesBinding.cLNoSearchItem.visibility = View.GONE
                } else {
                    homeFilesBinding.cLNoSearchItem.visibility = View.GONE

                }
            }
        }

    }

    private fun clickAction(clickItem: FileModel, action: Int) {
        clearSearchBar()

        when (action) {
            ACTION_OPEN -> {

                if (clickItem.isPdf) {

                    outputDirectory =
                        getOutputFileDirectory(
                            getString(R.string.pdf_dir)
                        )
                    outputDirectory.listFiles { file ->
                        clickItem.title.lowercase().trim()
                            .contains(file.nameWithoutExtension.lowercase().trim())
                    }!!.maxOrNull()?.let {
                        val uri = getUriPath(it.absolutePath)

                        val intent =
                            Intent(this, PdfFileViewerActivity::class.java)
                        intent.putExtra(FILE_URI, uri)
                        intent.putExtra(FILE_MODEL_OBJ, clickItem)
                        intent.putExtra(FILE_PATH, it.absolutePath)
                        startActivity(intent)
                        overridePendingTransition(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left
                        )

                    }

                }

            }
            ACTION_DELETE -> {
                showHomeItemDialog(clickItem, action)
            }
            ACTION_RENAME -> {
                showHomeItemDialog(clickItem, action)
            }
            ACTION_SHARE -> {
                if (clickItem.isPdf) {

                    lifecycleScope.launch {
                        whenCreated {
                            withContext(Dispatchers.IO) {
                                outputDirectory =
                                    getOutputFileDirectory(
                                        getString(R.string.pdf_dir)
                                    )
                                lifecycleScope.launch(Dispatchers.IO) {
                                    outputDirectory.listFiles { file ->
                                        clickItem.title.lowercase().trim()
                                            .contains(file.nameWithoutExtension.lowercase().trim())
                                    }!!.maxOrNull()?.let {
                                        val uri = getUriPath(it.absolutePath)

                                        val name = clickItem.title
                                        val shareIntent: Intent = Intent().apply {
                                            this.action = Intent.ACTION_SEND
                                            this.putExtra(Intent.EXTRA_STREAM, uri)
                                            this.type = "application/pdf"
                                            this.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                                        }

                                        startActivity(Intent.createChooser(shareIntent, name))
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }


    }

    private lateinit var outputDirectory: File

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(homeFilesBinding.root)

        fileViewModel.allFiles.observe(this) {
            homeFilesBinding.cLNoSearchItem.visibility = if (it.isEmpty()) {
                View.VISIBLE
            } else {
                View.GONE
            }
            handleObserver(it)
        }
        setToolbar()
        setListener()

    }

    private fun setListener() {

        homeFilesBinding.apply {

            toolbar.iVSearch.setOnClickListener {
                if (disableClick()) {
                    toolbar.toolbar.visibility = View.INVISIBLE
                    searchBar.cLSearchBar.visibility = View.VISIBLE
                    setEditTextChangeListener()
                }
            }
            searchBar.iVBackArrow.setOnClickListener {
                if (disableClick()) {
                    clearSearchBar()
                    hideKeyboard(it)
                }
            }

            homeFilesBinding.toolbar.iVBackArrow.setOnClickListener {

                finish()
            }
        }
    }

    private fun setToolbar() {
        homeFilesBinding.toolbar.iVBackArrow.visibility = View.VISIBLE
        homeFilesBinding.toolbar.iVSearch.visibility = View.VISIBLE
        homeFilesBinding.toolbar.tvToolbarTitle.visibility = View.VISIBLE
        homeFilesBinding.toolbar.tvToolbarTitle.setText(R.string.home_files)
    }

    private fun clearSearchBar() {
        hideKeyboard(homeFilesBinding.root)
        homeFilesBinding.toolbar.toolbar.visibility = View.VISIBLE
        homeFilesBinding.searchBar.cLSearchBar.visibility = View.INVISIBLE
        homeFilesBinding.searchBar.edtName.text.clear()
    }

    private fun setEditTextChangeListener() {
        openKeyboard()
        setHomeTextWatcher()
    }

    private fun openKeyboard() {
        homeFilesBinding.searchBar.edtName.postDelayed({
            homeFilesBinding.searchBar.edtName.requestFocus()
            showKeyboard()
        }, 100)
    }

    private fun setHomeTextWatcher() {
        homeFilesBinding.searchBar.edtName.addTextChangedListener(object : TextWatcher {

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
                if (fileModelArrayList.size > 0) {
                    homeFilesAdapter.filter.filter(s.trim())
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        clearSearchBar()
    }

    override fun onResume() {
        super.onResume()
        handleObserver(fileModelArrayList)
    }

    private fun handleObserver(list: List<FileModel>) {
        fileModelArrayList = list as ArrayList
        homeFilesAdapter.submitList(list)
        homeFilesAdapter.setAdapterList(list)
    }

    override fun onBackPressed() {

        finish()
    }

    private fun showHomeItemDialog(clickItem: FileModel, action: Int) {

        homeItemDialog =
            HomeItemDialog(clickItem, action, fun(draftClickItem: FileModel, action: Int) {

                when (action) {
                    ACTION_DELETE -> {
//                        fileModelArrayList.remove(draftClickItem)
                        lifecycleScope.launch {
                            fileViewModel.deleteFile(draftClickItem)
                        }
                    }
                    ACTION_RENAME -> {

                        val edtTitle =
                            homeItemDialog.itemHomeDialogBinding.edtName.text.trim().toString()

                        outputDirectory =
                            getOutputFileDirectory(
                                getString(R.string.pdf_dir)
                            )

                        outputDirectory.listFiles { file ->
                            edtTitle.lowercase().trim()
                                .contains(file.nameWithoutExtension.lowercase().trim())
                        }!!.maxOrNull()?.let {

                            Logger.debug("PDF_FILE::=>", it.toString())
                            if (it.nameWithoutExtension.lowercase().trim() == edtTitle) {
                                showToast(resources.getString(R.string.file_already_exist))
                                return
                            }
                        }

                        if (clickItem.isPdf) {

                            val newFile = createPdfFile(
                                outputDirectory,
                                edtTitle,
                                ".pdf"
                            )

                            val oldFile = createPdfFile(
                                outputDirectory,
                                clickItem.title,
                                ".pdf"
                            )

                            if (!newFile.exists()) {

                                if (oldFile.renameTo(newFile)) {

                                    addFile(this, newFile)
                                    removeFile(this, oldFile)
                                }
                            } else {
                                showToast(resources.getString(R.string.file_already_exist))

                            }
                        }

                        lifecycleScope.launch {
                            fileViewModel.updateFile(
                                edtTitle,
                                getCurrentDate(),
                                draftClickItem.noOfImages,
                                draftClickItem.imageQueueArrayList!!,
                                draftClickItem.isPdf, draftClickItem.title
                            )
                        }

                    }
                }
            })
        homeItemDialog.isCancelable = false
        homeItemDialog.show(
            supportFragmentManager,
            HomeItemDialog.TAG
        )
    }

    private fun removeFile(c: Context, f: File) {
        MediaScannerConnection.scanFile(c, arrayOf(f.toString()), null, null)
    }

    private fun addFile(c: Context, f: File?) {
        MediaScannerConnection.scanFile(c, arrayOf(f.toString()), null, null)
    }
}