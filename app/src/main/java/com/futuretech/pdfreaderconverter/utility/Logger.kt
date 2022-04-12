package com.futuretech.pdfreaderconverter.utility

import android.util.Log
import com.futuretech.pdfreaderconverter.BuildConfig

object Logger {

    fun info(tag: String, text: String?) {
        if (BuildConfig.DEBUG) Log.i(tag, text ?: "")
    }

    fun debug(tag: String, text: String?) {
        if (BuildConfig.DEBUG) Log.d(tag, text ?: "")
    }

    fun warning(tag: String, text: String?) {
        if (BuildConfig.DEBUG) Log.w(tag, text ?: "")
    }

}
