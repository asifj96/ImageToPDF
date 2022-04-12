package com.futuretech.pdfreaderconverter.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
@Entity(tableName = "FileModel")
data class FileModel(
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "timestamp") val timestamp: String,
    @ColumnInfo(name = "noOfImages") val noOfImages: Int,
    @ColumnInfo(name = "queueImage") val imageQueueArrayList: ArrayList<ImageQueue>?,
    @ColumnInfo(name = "isPdf") val isPdf: Boolean
) : Parcelable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
