package com.futuretech.pdfreaderconverter.app

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.futuretech.pdfreaderconverter.app.AppModule.allModules
import com.futuretech.pdfreaderconverter.app.AppModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppClass() : Application() {

    override fun onCreate() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate()

        startKoin {
            androidContext(this@AppClass)
            modules(listOf(allModules, viewModelModule))
        }
    }
}