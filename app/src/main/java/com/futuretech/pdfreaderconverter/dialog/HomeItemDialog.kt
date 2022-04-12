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
import com.futuretech.pdfreaderconverter.databinding.ItemHomeDialogBinding
import com.futuretech.pdfreaderconverter.extension.hideKeyboard
import com.futuretech.pdfreaderconverter.extension.showKeyboard
import com.futuretech.pdfreaderconverter.extension.showToast
import com.futuretech.pdfreaderconverter.extension.toEditable
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_DELETE
import com.futuretech.pdfreaderconverter.utility.Constants.ACTION_RENAME


data class HomeItemDialog(
    val clickItem: FileModel,
    val action: Int,
    private val clickAction: (FileModel, Int) -> Unit,
) :
    DialogFragment() {

    companion object {
        const val TAG = "HomeItemDialog"
    }

    val itemHomeDialogBinding: ItemHomeDialogBinding by lazy {
        ItemHomeDialogBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.card_bg)
        dialog!!.setCancelable(false)
        return itemHomeDialogBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDialogViews()
        itemHomeDialogBinding.tvCancel.setOnClickListener {
            context?.hideKeyboard(it)
            dismiss()
        }
        itemHomeDialogBinding.tvDelete.setOnClickListener {
            when (action) {
                ACTION_DELETE -> {
                    dialog?.dismiss()
                    clickAction.invoke(clickItem, action)
                }
                ACTION_RENAME -> {
                    val edtTitle =
                        itemHomeDialogBinding.edtName.text.trim().toString()
                    when {
                        edtTitle.isNotEmpty() -> {
                            if (clickItem.title == edtTitle) {
                                context?.showToast(getString(R.string.file_already_exist))
                            } else {
                                context?.hideKeyboard(itemHomeDialogBinding.edtName.rootView)
                                clickAction.invoke(clickItem, action)
                                dismiss()
                            }
                        }
                        else -> {
                            context?.showToast(getString(R.string.enter_edt_name))
                        }
                    }
                }
            }
        }
        itemHomeDialogBinding.iVClearText.setOnClickListener {
            itemHomeDialogBinding.edtName.text.clear()
        }
    }

    private fun setDialogViews() {

        when (action) {
            ACTION_RENAME -> {
                itemHomeDialogBinding.tvDeleteDocumentMsg.visibility = View.GONE
                itemHomeDialogBinding.edtName.visibility = View.VISIBLE
                itemHomeDialogBinding.edtName.text = clickItem.title.toEditable()
                itemHomeDialogBinding.iVClearText.visibility = View.VISIBLE
                itemHomeDialogBinding.viewLineEditText.visibility = View.VISIBLE
                itemHomeDialogBinding.tvTitle.text = getString(R.string.rename)
                itemHomeDialogBinding.tvDelete.text = getString(R.string.rename)

                itemHomeDialogBinding.edtName.postDelayed({
                    itemHomeDialogBinding.edtName.requestFocus()
                    itemHomeDialogBinding.edtName.setSelection(itemHomeDialogBinding.edtName.text.length)
                    context?.showKeyboard()
                }, 100)
            }
            ACTION_DELETE -> {
                itemHomeDialogBinding.tvDeleteDocumentMsg.visibility = View.VISIBLE
                itemHomeDialogBinding.edtName.visibility = View.GONE
                itemHomeDialogBinding.iVClearText.visibility = View.GONE
                itemHomeDialogBinding.viewLineEditText.visibility = View.GONE
                itemHomeDialogBinding.tvTitle.text = getString(R.string.delete)
                itemHomeDialogBinding.tvDelete.text = getString(R.string.delete)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
//        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}