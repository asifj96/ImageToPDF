package com.futuretech.pdfreaderconverter.data.viewmodel;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.futuretech.pdfreaderconverter.data.repo.ImageQueueRepository;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000b\u001a\u00020\fJ\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/futuretech/pdfreaderconverter/data/viewmodel/ImageQueueViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "allQueueImages", "Landroidx/lifecycle/LiveData;", "", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "repository", "Lcom/futuretech/pdfreaderconverter/data/repo/ImageQueueRepository;", "deleteAllQueueImages", "Lkotlinx/coroutines/Job;", "deleteQueueImage", "image", "(Lcom/futuretech/pdfreaderconverter/model/ImageQueue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertQueueImage", "app_release"})
public final class ImageQueueViewModel extends androidx.lifecycle.AndroidViewModel {
    private final androidx.lifecycle.LiveData<java.util.List<com.futuretech.pdfreaderconverter.model.ImageQueue>> allQueueImages = null;
    private final com.futuretech.pdfreaderconverter.data.repo.ImageQueueRepository repository = null;
    
    public ImageQueueViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertQueueImage(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.ImageQueue image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteQueueImage(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.ImageQueue image, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.Job> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job deleteAllQueueImages() {
        return null;
    }
}