package com.futuretech.pdfreaderconverter.ui.gallery;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.database.StaleDataException;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.adapter.GalleryAdapter;
import com.futuretech.pdfreaderconverter.databinding.ActivityGalleryScreenBinding;
import com.futuretech.pdfreaderconverter.model.GalleryModel;
import com.futuretech.pdfreaderconverter.ui.camera.CameraScreen;
import com.futuretech.pdfreaderconverter.utility.Logger;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0012\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/gallery/GalleryScreen;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "allFileCursor", "Landroid/database/Cursor;", "galleryBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityGalleryScreenBinding;", "getGalleryBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityGalleryScreenBinding;", "galleryBinding$delegate", "Lkotlin/Lazy;", "galleryImagesAdapter", "Lcom/futuretech/pdfreaderconverter/adapter/GalleryAdapter;", "getGalleryImagesAdapter", "()Lcom/futuretech/pdfreaderconverter/adapter/GalleryAdapter;", "galleryImagesAdapter$delegate", "galleryItemArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/GalleryModel;", "Lkotlin/collections/ArrayList;", "getGalleryImages", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setGalleryAdapter", "setGalleryData", "setListener", "setToolbar", "app_debug"})
public final class GalleryScreen extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy galleryBinding$delegate = null;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.GalleryModel> galleryItemArrayList;
    private android.database.Cursor allFileCursor;
    private final kotlin.Lazy galleryImagesAdapter$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public GalleryScreen() {
        super();
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.ActivityGalleryScreenBinding getGalleryBinding() {
        return null;
    }
    
    private final com.futuretech.pdfreaderconverter.adapter.GalleryAdapter getGalleryImagesAdapter() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setListener() {
    }
    
    private final void setToolbar() {
    }
    
    private final void setGalleryData() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void getGalleryImages() {
    }
    
    private final void setGalleryAdapter() {
    }
}