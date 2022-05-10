package com.futuretech.pdfreaderconverter.data.repo;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.futuretech.pdfreaderconverter.data.db.DB;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.ImageQueue;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0019\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017JQ\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00102\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"R\'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/repo/FileRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allFiles", "Landroidx/lifecycle/LiveData;", "", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "getAllFiles", "()Landroidx/lifecycle/LiveData;", "allFiles$delegate", "Lkotlin/Lazy;", "db", "Lcom/futuretech/pdfreaderconverter/data/db/DB;", "deleteFile", "", "file", "deleteFileByTitle", "", "title", "", "insertFile", "(Lcom/futuretech/pdfreaderconverter/model/FileModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFile", "timestamp", "noOfImages", "imagesList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "Lkotlin/collections/ArrayList;", "isPdf", "", "originalName", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/ArrayList;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class FileRepository {
    private com.futuretech.pdfreaderconverter.data.db.DB db;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy allFiles$delegate = null;
    
    public FileRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.futuretech.pdfreaderconverter.model.FileModel>> getAllFiles() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFile(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel file, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final int deleteFile(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel file) {
        return 0;
    }
    
    public final void deleteFileByTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFile(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String timestamp, int noOfImages, @org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imagesList, boolean isPdf, @org.jetbrains.annotations.NotNull()
    java.lang.String originalName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}