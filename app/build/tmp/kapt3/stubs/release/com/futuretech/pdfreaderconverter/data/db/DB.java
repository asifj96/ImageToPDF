package com.futuretech.pdfreaderconverter.data.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.futuretech.pdfreaderconverter.data.dao.FileDao;
import com.futuretech.pdfreaderconverter.data.dao.ImageQueueDao;
import com.futuretech.pdfreaderconverter.model.FileConverter;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.model.QueueImageConverter;

@androidx.room.TypeConverters(value = {com.futuretech.pdfreaderconverter.model.FileConverter.class, com.futuretech.pdfreaderconverter.model.QueueImageConverter.class})
@androidx.room.Database(entities = {com.futuretech.pdfreaderconverter.model.FileModel.class, com.futuretech.pdfreaderconverter.model.ImageQueue.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/db/DB;", "Landroidx/room/RoomDatabase;", "()V", "getFileDao", "Lcom/futuretech/pdfreaderconverter/data/dao/FileDao;", "getImageQueueDao", "Lcom/futuretech/pdfreaderconverter/data/dao/ImageQueueDao;", "Companion", "app_release"})
public abstract class DB extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.data.db.DB.Companion Companion = null;
    @kotlin.jvm.Volatile()
    private static volatile com.futuretech.pdfreaderconverter.data.db.DB instance;
    
    public DB() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.futuretech.pdfreaderconverter.data.dao.FileDao getFileDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.futuretech.pdfreaderconverter.data.dao.ImageQueueDao getImageQueueDao();
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/db/DB$Companion;", "", "()V", "instance", "Lcom/futuretech/pdfreaderconverter/data/db/DB;", "getDatabase", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.futuretech.pdfreaderconverter.data.db.DB getDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}