package com.futuretech.pdfreaderconverter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.futuretech.pdfreaderconverter.databinding.ActivityMainBinding
import com.futuretech.pdfreaderconverter.extension.showToast

class MainActivity : AppCompatActivity() {

    private val mBinding: ActivityMainBinding by lazy {

        ActivityMainBinding.inflate(layoutInflater)
    }
    private var doubleBackPressedOnce = false

    private val navHost: NavHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
    }
    private val navController: NavController by lazy {
        navHost.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mBinding.root)
    }

    override fun onBackPressed() {

        if (navController.currentDestination?.id != R.id.rootFragment) {
            val navOption = NavOptions.Builder()
                .setPopUpTo(navController.currentDestination?.id!!, true).build()
            navController.navigate(R.id.rootFragment, null, navOption)
        } else {
            if (doubleBackPressedOnce) {
                super.onBackPressed()
                finish()
                return
            }
            doubleBackPressedOnce = true
            val str = getString(R.string.click_back_again_to_exit)
            showToast(str)

            Handler(Looper.getMainLooper()).postDelayed({
                doubleBackPressedOnce = false
            }, 2000)
        }
    }
}