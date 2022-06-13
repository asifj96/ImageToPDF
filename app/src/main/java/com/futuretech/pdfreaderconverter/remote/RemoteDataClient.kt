package com.futuretech.pdfreaderconverter.remote

import android.content.Context
import androidx.annotation.Keep
import com.futuretech.pdfreaderconverter.R
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

class RemoteDataClient {

    private lateinit var remoteConfig: FirebaseRemoteConfig

    fun init(context: Context): FirebaseRemoteConfig {
        remoteConfig = FirebaseRemoteConfig.getInstance()
//        remoteConfig.setDefaultsAsync(R.xml.remote_config_default)
        val configSetting = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(400)
            .build()
        remoteConfig.setConfigSettingsAsync(configSetting)
        remoteConfig.setDefaultsAsync(
            mapOf(context.getString(R.string.remote_topic) to Gson().toJson(RemoteAdSettings()))
        )
        return remoteConfig
    }
}

@Keep
data class RemoteAdSettings(
    @SerializedName("main_native")
    val main_native: RemoteAdDetails = RemoteAdDetails(1),
)

@Keep
data class RemoteAdDetails(
    @SerializedName("value")
    val value: Int = 0,
)