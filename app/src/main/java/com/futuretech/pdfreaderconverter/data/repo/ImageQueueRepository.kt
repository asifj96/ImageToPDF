package com.futuretech.pdfreaderconverter.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.futuretech.pdfreaderconverter.data.db.DB
import com.futuretech.pdfreaderconverter.model.ImageQueue

class ImageQueueRepository(context: Context) {

    private lateinit var db: DB

    val allQueueImages: LiveData<List<ImageQueue>> by lazy {
        if (!::db.isInitialized) {
            db = DB.getDatabase(context)!!
        }
        db.getImageQueueDao().getAllQueueImage()
    }

    suspend fun insertQueueImage(image: ImageQueue) {
        db.getImageQueueDao().insertQueueImage(image)
    }

    suspend fun deleteQueueImage(image: ImageQueue) {
        db.getImageQueueDao().deleteQueueImage(image)
    }

    fun deleteAllQueueImages() {
        db.getImageQueueDao().deleteAllQueueImages()
    }
}