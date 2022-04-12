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
import com.futuretech.pdfreaderconverter.databinding.DialogPdfPasswordBinding
import com.futuretech.pdfreaderconverter.extension.hideKeyboard
import com.futuretech.pdfreaderconverter.extension.showKeyboard
import com.futuretech.pdfreaderconverter.extension.showToast
import com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity


class PdfPasswordDialog(
    private val clickAction: (String) -> Unit,
) :
    DialogFragment() {

    companion object {
        const val TAG = "PdfPasswordDialog"
    }

    private var pdfFileViewerActivity: PdfFileViewerActivity? = null
    private val dialogPasswordBinding: DialogPdfPasswordBinding by lazy {
        DialogPdfPasswordBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.card_bg)
        dialog!!.setCancelable(false)
        return dialogPasswordBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openKeyboard()

        dialogPasswordBinding.tvCancel.setOnClickListener {
            dialogPasswordBinding.tvCancel.context.hideKeyboard(it)
            dialog!!.dismiss()
            pdfFileViewerActivity?.apply {
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
                finish()
            }

        }
        dialogPasswordBinding.tvOk.setOnClickListener {

            val edtName = dialogPasswordBinding.edtName.text.trim().toString()

            if (edtName.isNotEmpty()) {
                clickAction.invoke(edtName)
                dialogPasswordBinding.edtName.context.hideKeyboard(it)
                dialog?.dismiss()
            } else {
                requireActivity().showToast(getString(R.string.enter_password_here))
            }
        }
        dialogPasswordBinding.iVClearText.setOnClickListener {
            dialogPasswordBinding.edtName.text.clear()
        }
    }

    private fun openKeyboard() {
        dialogPasswordBinding.edtName.postDelayed({
            dialogPasswordBinding.edtName.requestFocus()
            requireActivity().showKeyboard()
        }, 100)
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
//        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    fun setData(pdfViewerActivity: PdfFileViewerActivity) {
        this.pdfFileViewerActivity = pdfViewerActivity
    }
}