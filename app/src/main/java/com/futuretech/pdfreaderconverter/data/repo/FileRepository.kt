package com.futuretech.pdfreaderconverter.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import com.futuretech.pdfreaderconverter.data.db.DB
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.ImageQueue

class FileRepository(context: Context) {

    private lateinit var db: DB

    val allFiles: LiveData<List<FileModel>> by lazy {
        if (!::db.isInitialized) {
            db = DB.getDatabase(context)!!
        }
        db.getFileDao().getAllFiles()
    }

    suspend fun insertFile(file: FileModel) {
        db.getFileDao().insertFile(file)
    }

    fun deleteFile(file: FileModel): Int {
        return db.getFileDao().deleteFile(file)
    }

    fun deleteFileByTitle(title: String) {
        return db.getFileDao().deleteFileByTitle(title)
    }

    suspend fun updateFile(
        title: String,
        timestamp: String,
        noOfImages: Int,
        imagesList: ArrayList<ImageQueue>,
        isPdf: Boolean,
        originalName: String,
    ) {
        db.getFileDao().updateFile(
            title,
            timestamp,
            noOfImages,
            imagesList,
            isPdf,
            originalName
        )
    }

}