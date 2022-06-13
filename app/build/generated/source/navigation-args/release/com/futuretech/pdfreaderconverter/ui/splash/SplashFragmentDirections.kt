package com.futuretech.pdfreaderconverter.ui.splash

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.futuretech.pdfreaderconverter.R

public class SplashFragmentDirections private constructor() {
  public companion object {
    public fun actionSplashFragmentToRootFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_rootFragment)
  }
}
