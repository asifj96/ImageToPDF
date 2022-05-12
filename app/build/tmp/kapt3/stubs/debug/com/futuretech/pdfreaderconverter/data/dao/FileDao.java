package com.futuretech.pdfreaderconverter.data.dao;

import androidx.lifecycle.LiveData;
import androidx.room.*;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.ImageQueue;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\'J\u0019\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\'J\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\u0010H\'J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013JQ\u0010\u0014\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00062\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0018j\b\u0012\u0004\u0012\u00020\u0019`\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/dao/FileDao;", "", "deleteAllFiles", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFile", "", "file", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "deleteFileById", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFileByTitle", "title", "", "getAllFiles", "Landroidx/lifecycle/LiveData;", "", "insertFile", "(Lcom/futuretech/pdfreaderconverter/model/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFile", "timestamp", "noOfImages", "imagesList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "Lkotlin/collections/ArrayList;", "isPdf", "", "originalName", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface FileDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * from FileModel order by id desc")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.futuretech.pdfreaderconverter.model.FileModel>> getAllFiles();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object insertFile(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @androidx.room.Delete()
    public abstract int deleteFile(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel file);
    
    @androidx.room.Query(value = "DELETE FROM FileModel WHERE title = :title")
    public abstract void deleteFileByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM FileModel WHERE id = :id")
    public abstract java.lang.Object deleteFileById(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "delete from FileModel")
    public abstract java.lang.Object deleteAllFiles(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "UPDATE FileModel SET title = :title,timestamp= :timestamp,noOfImages= :noOfImages,queueImage= :imagesList,isPdf= :isPdf WHERE title LIKE :originalName")
    public abstract java.lang.Object updateFile(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String timestamp, int noOfImages, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imagesList, boolean isPdf, @org.jetbrains.annotations.NotNull()
    java.lang.String originalName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}