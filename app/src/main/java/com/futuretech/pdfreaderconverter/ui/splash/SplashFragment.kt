package com.futuretech.pdfreaderconverter.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.databinding.FragmentSplashBinding
import com.futuretech.pdfreaderconverter.ui.base.BaseFragment

class SplashFragment : BaseFragment() {

    private lateinit var mBinding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        return mBinding.root
    }

    private fun startHandler() {
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_rootFragment)
        }, 3000)
    }

    override fun onResume() {
        super.onResume()
        startHandler()
    }
}