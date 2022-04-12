package com.futuretech.pdfreaderconverter.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.futuretech.pdfreaderconverter.databinding.LoadingDialogBinding


class LoadingDialog :
    DialogFragment() {

    companion object {
        const val TAG = "LoadingDialog"
    }

    private var title: String = ""
    private lateinit var mBinding: LoadingDialogBinding

    fun setTitle(title: String) {
        this.title = title
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = LoadingDialogBinding.inflate(layoutInflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvTitle.text = title
    }

}