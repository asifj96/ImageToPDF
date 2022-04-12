package com.futuretech.pdfreaderconverter.model

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class PdfFile(
    val id: Int,
    var name: String,
    val mimeType: String,
    val date: Long,
    val size: String,
    var uri: Uri? = null,
    var path: String,
) : Parcelable