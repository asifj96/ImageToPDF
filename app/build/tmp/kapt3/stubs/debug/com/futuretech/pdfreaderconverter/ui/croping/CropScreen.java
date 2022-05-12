package com.futuretech.pdfreaderconverter.ui.croping;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.ActivityCropScreenBinding;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen;
import com.futuretech.pdfreaderconverter.utility.Logger;
import kotlinx.coroutines.*;
import java.io.File;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/croping/CropScreen;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "angle", "", "cropScreenBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityCropScreenBinding;", "getCropScreenBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityCropScreenBinding;", "cropScreenBinding$delegate", "Lkotlin/Lazy;", "imageQueueArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "Lkotlin/collections/ArrayList;", "job", "Lkotlinx/coroutines/CompletableJob;", "mCurrentImageIndex", "outputDirectory", "Ljava/io/File;", "photoFile", "rotatedBitmap", "Landroid/graphics/Bitmap;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "uriPath", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setIntentData", "setListener", "setToolbar", "app_debug"})
public final class CropScreen extends androidx.appcompat.app.AppCompatActivity {
    private java.io.File photoFile;
    private int mCurrentImageIndex = 0;
    private java.lang.String uriPath = "";
    private android.graphics.Bitmap rotatedBitmap;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList;
    private java.io.File outputDirectory;
    private kotlinx.coroutines.CompletableJob job;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private int angle = 90;
    private final kotlin.Lazy cropScreenBinding$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public CropScreen() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getScope() {
        return null;
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.ActivityCropScreenBinding getCropScreenBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setIntentData() {
    }
    
    private final void setToolbar() {
    }
    
    private final void setListener() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}