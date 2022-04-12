package com.futuretech.pdfreaderconverter.model

import android.net.Uri
import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class GalleryModel(
    val id: Int,
    val date: Long,
    val size: Long,
    val uri: Uri? = null,
    val path: String,
    var isSelected: Boolean = false
) : Parcelable
