package com.futuretech.pdfreaderconverter.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class QueueImageConverter {

    @TypeConverter
    fun fromString(value: String): ArrayList<ImageQueue> {
        val listType = object : TypeToken<List<ImageQueue>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<ImageQueue>): String {
        return Gson().toJson(list)
    }
}