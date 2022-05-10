package com.futuretech.pdfreaderconverter.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.futuretech.pdfreaderconverter.model.ImageQueue;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0019\u0010\f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/dao/ImageQueueDao;", "", "deleteAllQueueImages", "", "deleteQueueImage", "", "queueImage", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "(Lcom/futuretech/pdfreaderconverter/model/ImageQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllQueueImage", "Landroidx/lifecycle/LiveData;", "", "insertQueueImage", "app_release"})
public abstract interface ImageQueueDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * from ImageQueue order by id desc")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.futuretech.pdfreaderconverter.model.ImageQueue>> getAllQueueImage();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertQueueImage(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.ImageQueue queueImage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteQueueImage(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.ImageQueue queueImage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Query(value = "delete from ImageQueue")
    public abstract int deleteAllQueueImages();
}