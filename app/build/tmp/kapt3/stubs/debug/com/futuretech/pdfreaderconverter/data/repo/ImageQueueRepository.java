package com.futuretech.pdfreaderconverter.data.repo;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.futuretech.pdfreaderconverter.data.db.DB;
import com.futuretech.pdfreaderconverter.model.ImageQueue;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/repo/ImageQueueRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "allQueueImages", "Landroidx/lifecycle/LiveData;", "", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "getAllQueueImages", "()Landroidx/lifecycle/LiveData;", "allQueueImages$delegate", "Lkotlin/Lazy;", "db", "Lcom/futuretech/pdfreaderconverter/data/db/DB;", "deleteAllQueueImages", "", "deleteQueueImage", "image", "(Lcom/futuretech/pdfreaderconverter/model/ImageQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertQueueImage", "app_debug"})
public final class ImageQueueRepository {
    private com.futuretech.pdfreaderconverter.data.db.DB db;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy allQueueImages$delegate = null;
    
    public ImageQueueRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.futuretech.pdfreaderconverter.model.ImageQueue>> getAllQueueImages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertQueueImage(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.ImageQueue image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteQueueImage(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.ImageQueue image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void deleteAllQueueImages() {
    }
}