package com.futuretech.pdfreaderconverter.ui.editing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.viewpager.widget.ViewPager;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.ActivityEditImageScreenBinding;
import com.futuretech.pdfreaderconverter.dialog.SaveAsPdfDialog;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.ui.base.BaseActivity;
import com.futuretech.pdfreaderconverter.ui.croping.CropScreen;
import com.futuretech.pdfreaderconverter.ui.filter.FilterScreen;
import com.futuretech.pdfreaderconverter.ui.home.HomeFiles;
import com.futuretech.pdfreaderconverter.utility.Logger;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import kotlinx.coroutines.*;
import java.io.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u00100\u001a\u000201H\u0002J0\u00102\u001a\u0002012\u0006\u00103\u001a\u00020/2\u0016\u00104\u001a\u0012\u0012\u0004\u0012\u0002050\u0011j\b\u0012\u0004\u0012\u000205`\u00192\u0006\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u000201H\u0002J\b\u00108\u001a\u000201H\u0002J \u00109\u001a\u0002012\u0006\u0010:\u001a\u00020\u00122\u0006\u0010;\u001a\u00020/2\u0006\u00106\u001a\u00020#H\u0002J\b\u0010<\u001a\u000201H\u0002J\b\u0010=\u001a\u000201H\u0016J\u0012\u0010>\u001a\u0002012\b\u0010?\u001a\u0004\u0018\u00010@H\u0014J\b\u0010A\u001a\u000201H\u0002J\b\u0010B\u001a\u000201H\u0002J\u0010\u0010C\u001a\u0002012\u0006\u00103\u001a\u00020/H\u0002J\u0010\u0010D\u001a\u0002012\u0006\u0010E\u001a\u00020#H\u0002J\b\u0010F\u001a\u000201H\u0002J\b\u0010G\u001a\u000201H\u0002J\b\u0010H\u001a\u000201H\u0002J\b\u0010I\u001a\u000201H\u0002J\b\u0010J\u001a\u000201H\u0002J\b\u0010K\u001a\u000201H\u0002J \u0010L\u001a\u0002012\u0006\u00103\u001a\u00020/2\u0006\u0010:\u001a\u00020\u00122\u0006\u0010M\u001a\u00020NH\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR*\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0011j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020(X\u0082.\u00a2\u0006\u0002\n\u0000R\u0011\u0010)\u001a\u00020*\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001e\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0011j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/editing/EditImageScreen;", "Lcom/futuretech/pdfreaderconverter/ui/base/BaseActivity;", "()V", "cropImageLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getCropImageLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setCropImageLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "editImageBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityEditImageScreenBinding;", "getEditImageBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityEditImageScreenBinding;", "editImageBinding$delegate", "Lkotlin/Lazy;", "fileArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "fileObj", "filterLauncher", "getFilterLauncher", "setFilterLauncher", "imageQueueArrayList", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "Lkotlin/collections/ArrayList;", "getImageQueueArrayList", "()Ljava/util/ArrayList;", "setImageQueueArrayList", "(Ljava/util/ArrayList;)V", "imageViewPagerAdapter", "Lcom/futuretech/pdfreaderconverter/ui/editing/ImageViewPagerAdapter;", "job", "Lkotlinx/coroutines/CompletableJob;", "mCurrentImageIndex", "", "outputDirectory", "Ljava/io/File;", "photoFile", "saveAsPDFDialog", "Lcom/futuretech/pdfreaderconverter/dialog/SaveAsPdfDialog;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "tempImageQueueArrayList", "uriPath", "", "checkIntentValues", "", "createPdfFromBitmap", "edtTitle", "bitmapArrayList", "Landroid/graphics/Bitmap;", "quality", "deleteQueueImage", "disableNextPreviousButton", "handleAction", "clickItem", "converterString", "nextImageClicked", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "previousImageClicked", "setAdapter", "setFileData", "setImageNumber", "selectedPos", "setListener", "setToolbar", "showSaveAsPDFDialog", "startCropScreen", "startFiltersScreen", "startHomeScreen", "updateFileModel", "isPDF", "", "app_release"})
public final class EditImageScreen extends com.futuretech.pdfreaderconverter.ui.base.BaseActivity {
    private com.futuretech.pdfreaderconverter.dialog.SaveAsPdfDialog saveAsPDFDialog;
    private final kotlin.Lazy editImageBinding$delegate = null;
    private java.lang.String uriPath = "";
    private com.futuretech.pdfreaderconverter.model.FileModel fileObj;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.FileModel> fileArrayList;
    private java.io.File outputDirectory;
    private int mCurrentImageIndex = 0;
    private com.futuretech.pdfreaderconverter.ui.editing.ImageViewPagerAdapter imageViewPagerAdapter;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList;
    private kotlinx.coroutines.CompletableJob job;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> tempImageQueueArrayList;
    private java.io.File photoFile;
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> cropImageLauncher;
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> filterLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public EditImageScreen() {
        super();
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.ActivityEditImageScreenBinding getEditImageBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> getImageQueueArrayList() {
        return null;
    }
    
    public final void setImageQueueArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getScope() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkIntentValues() {
    }
    
    private final void setImageNumber(int selectedPos) {
    }
    
    private final void disableNextPreviousButton() {
    }
    
    private final void nextImageClicked() {
    }
    
    private final void previousImageClicked() {
    }
    
    private final void setListener() {
    }
    
    private final void setFileData(java.lang.String edtTitle) {
    }
    
    private final void showSaveAsPDFDialog() {
    }
    
    private final void handleAction(com.futuretech.pdfreaderconverter.model.FileModel clickItem, java.lang.String converterString, int quality) {
    }
    
    private final void createPdfFromBitmap(java.lang.String edtTitle, java.util.ArrayList<android.graphics.Bitmap> bitmapArrayList, int quality) {
    }
    
    private final void updateFileModel(java.lang.String edtTitle, com.futuretech.pdfreaderconverter.model.FileModel clickItem, boolean isPDF) {
    }
    
    private final void startHomeScreen() {
    }
    
    private final void deleteQueueImage() {
    }
    
    private final void setToolbar() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getCropImageLauncher() {
        return null;
    }
    
    public final void setCropImageLauncher(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    private final void setAdapter() {
    }
    
    private final void startCropScreen() {
    }
    
    private final void startFiltersScreen() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getFilterLauncher() {
        return null;
    }
    
    public final void setFilterLauncher(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
}