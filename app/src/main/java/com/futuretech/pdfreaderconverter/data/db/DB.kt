package com.futuretech.pdfreaderconverter.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.futuretech.pdfreaderconverter.data.dao.FileDao
import com.futuretech.pdfreaderconverter.data.dao.ImageQueueDao
import com.futuretech.pdfreaderconverter.model.FileConverter
import com.futuretech.pdfreaderconverter.model.FileModel
import com.futuretech.pdfreaderconverter.model.ImageQueue
import com.futuretech.pdfreaderconverter.model.QueueImageConverter

@Database(entities = [FileModel::class, ImageQueue::class], version = 1, exportSchema = false)
@TypeConverters(
    FileConverter::class, QueueImageConverter::class
)
abstract class DB : RoomDatabase() {

    abstract fun getFileDao(): FileDao
    abstract fun getImageQueueDao(): ImageQueueDao

    companion object {

        @Volatile
        private var instance: DB? = null

        fun getDatabase(context: Context): DB? {

            if (instance == null) {
                synchronized(RoomDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DB::class.java, "image_pdf_db"
                    )
                        .fallbackToDestructiveMigration() // when version increments, it migrates (deletes db and creates new) - else it crashes
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return instance
        }
    }
}