package com.futuretech.pdfreaderconverter.dialog

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.DialogConfirmationBinding
import com.futuretech.pdfreaderconverter.extension.hideKeyboard

class ConfirmationDialog(
    private val activity: Activity,
    private val clickAction: (Activity) -> Unit,
) :
    DialogFragment() {

    companion object {
        const val TAG = "ConfirmationDialog"
    }

    private val confirmationBinding: DialogConfirmationBinding by lazy {
        DialogConfirmationBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.card_bg)
        dialog!!.setCancelable(false)
        return confirmationBinding.root
    }

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        confirmationBinding.tvCancel.setOnClickListener {
            requireActivity().hideKeyboard(it)
            dialog!!.dismiss()
        }
        confirmationBinding.tvDiscard.setOnClickListener {
            clickAction.invoke(activity)
            dialog!!.dismiss()
            requireActivity().hideKeyboard(it)
        }
    }

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.95).toInt()
//        val height = (resources.displayMetrics.heightPixels * 0.40).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}