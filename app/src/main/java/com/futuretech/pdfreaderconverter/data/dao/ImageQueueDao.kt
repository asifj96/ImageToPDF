package com.futuretech.pdfreaderconverter.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.futuretech.pdfreaderconverter.model.ImageQueue

@Dao
interface ImageQueueDao {

    @Query("SELECT * from ImageQueue order by id desc")
    fun getAllQueueImage(): LiveData<List<ImageQueue>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQueueImage(queueImage: ImageQueue)

    @Delete
    suspend fun deleteQueueImage(queueImage: ImageQueue)

    @Query("delete from ImageQueue")
    fun deleteAllQueueImages(): Int

}