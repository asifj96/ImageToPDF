package com.futuretech.pdfreaderconverter.dialog

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.FileOperationDialogBinding
import com.futuretech.pdfreaderconverter.extension.hideKeyboard
import com.futuretech.pdfreaderconverter.extension.showKeyboard
import com.futuretech.pdfreaderconverter.extension.showToast
import com.futuretech.pdfreaderconverter.extension.toEditable
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.PdfFile
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_DELETE
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_RENAME

class FileOperationDialog(
    val clickItem: Any,
    val action: Int,
    private val clickAction: (Any, Int, Boolean) -> Unit,
) :
    DialogFragment() {

    companion object {
        const val TAG = "FileOperationDialog"
    }

    val fileOperationDialogBinding: FileOperationDialogBinding by lazy {
        FileOperationDialogBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.card_bg)
        dialog!!.setCancelable(false)
        return fileOperationDialogBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDialogViews()
        fileOperationDialogBinding.tvCancel.setOnClickListener {
            requireActivity().hideKeyboard(it)
            dialog!!.dismiss()
        }
        fileOperationDialogBinding.tvDelete.setOnClickListener {
            when (action) {
                ACTION_DELETE -> {
                    clickAction.invoke(clickItem, action, true)
                    dialog?.dismiss()
                }
                ACTION_RENAME -> {
                    val edtName = fileOperationDialogBinding.edtName.text.toString().trim()
                    if (edtName.isNotEmpty()) {
                        if (clickItem is PdfFile) {
                            if (clickItem.name == edtName) {
                                requireActivity().showToast(getString(R.string.file_already_exist))
                            } else {
                                clickAction.invoke(clickItem, action, false)
                                requireActivity().hideKeyboard(it)
                                dialog?.dismiss()
                            }
                        } else if (clickItem is FileModel) {
                            if (clickItem.title == edtName) {
                                requireActivity().showToast(getString(R.string.file_already_exist))
                            } else {
                                clickAction.invoke(clickItem, action, false)
                                requireActivity().hideKeyboard(it)
                                dialog?.dismiss()
                            }
                        }

                    } else {
                        requireActivity().showToast(resources.getString(R.string.enter_name_here))
                    }
                }
            }
        }
        fileOperationDialogBinding.iVClearText.setOnClickListener {
            fileOperationDialogBinding.edtName.text.clear()
        }
    }

    private fun setDialogViews() {

        when (action) {
            ACTION_RENAME -> {
                fileOperationDialogBinding.tvDeleteDocumentMsg.visibility = View.GONE
                fileOperationDialogBinding.edtName.visibility = View.VISIBLE
                if (clickItem is PdfFile) {
                    fileOperationDialogBinding.edtName.text = clickItem.name.toEditable()
                } else if (clickItem is FileModel) {
                    fileOperationDialogBinding.edtName.text = clickItem.title.toEditable()
                }
                fileOperationDialogBinding.iVClearText.visibility = View.VISIBLE
                fileOperationDialogBinding.viewLineEditText.visibility = View.VISIBLE
                fileOperationDialogBinding.tvTitle.text = getString(R.string.rename_document)
                fileOperationDialogBinding.tvDelete.text = getString(R.string.rename)

                fileOperationDialogBinding.edtName.postDelayed({
                    fileOperationDialogBinding.edtName.requestFocus()
                    fileOperationDialogBinding.edtName.setSelection(fileOperationDialogBinding.edtName.text.length)
                    requireActivity().showKeyboard()
                }, 100)
            }
            ACTION_DELETE -> {
                fileOperationDialogBinding.tvDeleteDocumentMsg.visibility = View.VISIBLE
                fileOperationDialogBinding.edtName.visibility = View.GONE
                fileOperationDialogBinding.iVClearText.visibility = View.GONE
                fileOperationDialogBinding.viewLineEditText.visibility = View.GONE
                fileOperationDialogBinding.tvTitle.text = getString(R.string.delete_document)
                fileOperationDialogBinding.tvDelete.text = getString(R.string.delete)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}