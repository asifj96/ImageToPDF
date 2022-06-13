package com.futuretech.pdfreaderconverter.remote

import android.app.Activity
import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.gson.Gson
import com.futuretech.pdfreaderconverter.R

class RemoteConfigViewModel(private val remoteData: FirebaseRemoteConfig) : ViewModel() {

    var remoteConfig: MutableLiveData<RemoteAdSettings> = MutableLiveData()

    fun getRemoteConfigInit(context: Activity) {
        remoteData.fetchAndActivate()
            .addOnCompleteListener(context) { task ->
                if (task.isSuccessful) {
                    remoteConfig.value = Gson().fromJson(
                        remoteData.getString(context.getString(R.string.remote_topic)),
                        RemoteAdSettings::class.java
                    )
                }
            }
    }

    fun getRemoteConfig(context: Context): RemoteAdSettings {
        return Gson().fromJson(
            remoteData.getString(context.getString(R.string.remote_topic)),
            RemoteAdSettings::class.java
        )
    }
}