package com.futuretech.pdfreaderconverter.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.DialogSaveAsPdfBinding
import com.futuretech.pdfreaderconverter.extension.*
import com.futuretech.pdfreaderconverter.model.FileModel

class SaveAsPdfDialog(
    private val fileModelObj: FileModel,
    private val clickAction: (FileModel, String, Int) -> Unit,
) :
    DialogFragment() {

    companion object {
        const val TAG = "SaveAsPdfDialog"
    }

    val dialogSaveAsPdfBinding: DialogSaveAsPdfBinding by lazy {
        DialogSaveAsPdfBinding.inflate(layoutInflater)
    }

    private var hasPDFSelect: Boolean = true
    private var hasLowQuality: Boolean = false
    private var hasMediumQuality: Boolean = false
    private var hasRegularQuality: Boolean = true
    private var hasMaxQuality: Boolean = false
    private var converterString: String = "PDF"
    private var quality: Int = 65
    private var extension: String = ".pdf"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.card_bg)
        dialog!!.setCancelable(false)
        return dialogSaveAsPdfBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViews()
        dialogSaveAsPdfBinding.tvCancel.setOnClickListener {
            context?.hideKeyboard(it)
            dialog!!.dismiss()
        }
        dialogSaveAsPdfBinding.tvSave.setOnClickListener {
            if (disableClick()) {
                val edtName = dialogSaveAsPdfBinding.edtName.text.trim().toString()

                when {
                    edtName.isNotEmpty() -> {
                        context?.hideKeyboard(dialogSaveAsPdfBinding.edtName.rootView)
                        clickAction.invoke(fileModelObj, converterString, quality)
                        dismiss()
                        /* if (fileModelObj.title == edtName) {
                             context?.showToast(getString(R.string.already_exist))
                         } else {
                             context?.hideKeyboard(dialogSaveAsPdfBinding.edtName.rootView)
                             clickAction.invoke(fileModelObj, converterString, quality, isPDF)
                             dismiss()
                         }*/
                    }
                    else -> {
                        context?.showToast(getString(R.string.enter_edt_name))
                    }
                }

                /*if (edtName.isNotEmpty()) {
                    context?.hideKeyboard(it)
                    dialog!!.dismiss()
                    clickAction.invoke(fileModelObj, converterString, quality, isPDF)
                } else {
                    context?.showToast(getString(R.string.enter_edt_name))
                }*/
            }
        }
        dialogSaveAsPdfBinding.iVClearText.setOnClickListener {
            dialogSaveAsPdfBinding.edtName.text.clear()
        }

        dialogSaveAsPdfBinding.iVSelectedPDF.setOnClickListener {

            if (!hasPDFSelect) {
                converterString = "PDF"
                extension = ".pdf"
                hasPDFSelect = true
                dialogSaveAsPdfBinding.iVSelectedPDF.setImageResource(R.drawable.ic_checked_icon)
            }
        }
        dialogSaveAsPdfBinding.iVLowQuality.setOnClickListener {

            if (!hasLowQuality) {
                quality = 40
                hasLowQuality = true
                hasMediumQuality = false
                hasRegularQuality = false
                hasMaxQuality = false

                dialogSaveAsPdfBinding.iVLowQuality.setImageResource(R.drawable.ic_circle_fill_icon)
                dialogSaveAsPdfBinding.iVMediumQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVRegularQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVMaxQuality.setImageResource(R.drawable.ic_circle_blank_icon)
            }

        }
        dialogSaveAsPdfBinding.iVMediumQuality.setOnClickListener {

            if (!hasMediumQuality) {
                quality = 55

                hasLowQuality = false
                hasMediumQuality = true
                hasRegularQuality = false
                hasMaxQuality = false

                dialogSaveAsPdfBinding.iVMediumQuality.setImageResource(R.drawable.ic_circle_fill_icon)
                dialogSaveAsPdfBinding.iVLowQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVRegularQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVMaxQuality.setImageResource(R.drawable.ic_circle_blank_icon)
            }
        }

        dialogSaveAsPdfBinding.iVRegularQuality.setOnClickListener {

            if (!hasRegularQuality) {
                quality = 65

                hasLowQuality = false
                hasMediumQuality = false
                hasRegularQuality = true
                hasMaxQuality = false

                dialogSaveAsPdfBinding.iVRegularQuality.setImageResource(R.drawable.ic_circle_fill_icon)
                dialogSaveAsPdfBinding.iVLowQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVMediumQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVMaxQuality.setImageResource(R.drawable.ic_circle_blank_icon)
            }
        }
        dialogSaveAsPdfBinding.iVMaxQuality.setOnClickListener {
            if (!hasMaxQuality) {
                quality = 80
                hasLowQuality = false
                hasMediumQuality = false
                hasRegularQuality = false
                hasMaxQuality = true

                dialogSaveAsPdfBinding.iVMaxQuality.setImageResource(R.drawable.ic_circle_fill_icon)
                dialogSaveAsPdfBinding.iVLowQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVMediumQuality.setImageResource(R.drawable.ic_circle_blank_icon)
                dialogSaveAsPdfBinding.iVRegularQuality.setImageResource(R.drawable.ic_circle_blank_icon)
            }
        }
    }

    private fun setViews() {

        dialogSaveAsPdfBinding.tVRegularQuality.setTextColor(
            ContextCompat.getColor(
                requireContext(),
                R.color.white
            )
        )
        dialogSaveAsPdfBinding.edtName.text = fileModelObj.title.toEditable()

        dialogSaveAsPdfBinding.edtName.postDelayed({
            dialogSaveAsPdfBinding.edtName.requestFocus()
            dialogSaveAsPdfBinding.edtName.setSelection(dialogSaveAsPdfBinding.edtName.text.length)
            requireActivity().showKeyboard()
        }, 100)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
//        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onPause() {
        super.onPause()
        context?.hideKeyboard(dialogSaveAsPdfBinding.edtName)
        dismiss()
    }
}