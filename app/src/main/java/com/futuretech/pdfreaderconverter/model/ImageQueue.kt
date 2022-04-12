package com.futuretech.pdfreaderconverter.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
@Entity(tableName = "ImageQueue")
data class ImageQueue(
    @ColumnInfo(name = "uriPath") var uriPath: String?,
    var isSelected: Boolean = false,
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
