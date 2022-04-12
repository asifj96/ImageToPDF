package com.futuretech.pdfreaderconverter.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.ImageQueue

@Dao
interface FileDao {

    @Query("SELECT * from FileModel order by id desc")
    fun getAllFiles(): LiveData<List<FileModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFile(file: FileModel)

    @Delete
    fun deleteFile(file: FileModel): Int

    @Query("DELETE FROM FileModel WHERE title = :title")
    fun deleteFileByTitle(title: String)

    @Query("DELETE FROM FileModel WHERE id = :id")
    suspend fun deleteFileById(id: Int)

    @Query("delete from FileModel")
    suspend fun deleteAllFiles()

    @Query("UPDATE FileModel SET title = :title,timestamp= :timestamp,noOfImages= :noOfImages,queueImage= :imagesList,isPdf= :isPdf WHERE title LIKE :originalName")
    suspend fun updateFile(
        title: String,
        timestamp: String,
        noOfImages: Int,
        imagesList: ArrayList<ImageQueue>,
        isPdf: Boolean,
        originalName: String,
    )

}