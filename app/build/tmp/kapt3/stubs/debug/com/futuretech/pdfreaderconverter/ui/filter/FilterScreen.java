package com.futuretech.pdfreaderconverter.ui.filter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.ActivityFilterScreenBinding;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.FilterScreenModel;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen;
import com.futuretech.pdfreaderconverter.utility.Logger;
import kotlinx.coroutines.*;
import java.io.File;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\fj\b\u0012\u0004\u0012\u00020\u001f`\u000eH\u0002J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u0012H\u0002J\b\u0010$\u001a\u00020!H\u0016J\u0012\u0010%\u001a\u00020!2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\b\u0010(\u001a\u00020!H\u0002J\b\u0010)\u001a\u00020!H\u0002J\b\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020!H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/filter/FilterScreen;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "colorFilter", "Lcom/futuretech/pdfreaderconverter/ui/filter/ColorFilters;", "filterScreenBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityFilterScreenBinding;", "getFilterScreenBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityFilterScreenBinding;", "filterScreenBinding$delegate", "Lkotlin/Lazy;", "imageQueueArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "Lkotlin/collections/ArrayList;", "job", "Lkotlinx/coroutines/CompletableJob;", "mCurrentImageIndex", "", "outputDirectory", "Ljava/io/File;", "photoFile", "rotatedBitmap", "Landroid/graphics/Bitmap;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "uriPath", "", "getColorFilterNameArrayList", "Lcom/futuretech/pdfreaderconverter/model/FilterScreenModel;", "handleClickAction", "", "item", "pos", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setFiltersAdapter", "setIntentData", "setListener", "setToolbar", "app_debug"})
public final class FilterScreen extends androidx.appcompat.app.AppCompatActivity {
    private final kotlin.Lazy filterScreenBinding$delegate = null;
    private java.io.File photoFile;
    private android.graphics.Bitmap rotatedBitmap;
    private int mCurrentImageIndex = 0;
    private java.lang.String uriPath = "";
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList;
    private final com.futuretech.pdfreaderconverter.ui.filter.ColorFilters colorFilter = null;
    private kotlinx.coroutines.CompletableJob job;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private java.io.File outputDirectory;
    private java.util.HashMap _$_findViewCache;
    
    public FilterScreen() {
        super();
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.ActivityFilterScreenBinding getFilterScreenBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getScope() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setIntentData() {
    }
    
    private final void setFiltersAdapter() {
    }
    
    private final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.FilterScreenModel> getColorFilterNameArrayList() {
        return null;
    }
    
    private final void handleClickAction(com.futuretech.pdfreaderconverter.model.FilterScreenModel item, int pos) {
    }
    
    private final void setToolbar() {
    }
    
    private final void setListener() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
}