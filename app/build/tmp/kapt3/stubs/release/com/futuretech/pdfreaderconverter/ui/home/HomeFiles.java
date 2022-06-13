package com.futuretech.pdfreaderconverter.ui.home;

import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.adapter.HomeFilesAdapter;
import com.futuretech.pdfreaderconverter.databinding.ActivityHomeFilesBinding;
import com.futuretech.pdfreaderconverter.dialog.HomeItemDialog;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.ui.base.BaseActivity;
import com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity;
import com.futuretech.pdfreaderconverter.utility.Logger;
import kotlinx.coroutines.Dispatchers;
import java.io.File;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\u00020\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"H\u0002J\b\u0010#\u001a\u00020\u0017H\u0016J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010\'\u001a\u00020\u0017H\u0014J\b\u0010(\u001a\u00020\u0017H\u0014J\b\u0010)\u001a\u00020\u0017H\u0002J\u0018\u0010*\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J \u0010+\u001a\u00020\u00172\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\u0018\u00101\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00062"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/home/HomeFiles;", "Lcom/futuretech/pdfreaderconverter/ui/base/BaseActivity;", "()V", "fileModelArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "Lkotlin/collections/ArrayList;", "homeFilesAdapter", "Lcom/futuretech/pdfreaderconverter/adapter/HomeFilesAdapter;", "getHomeFilesAdapter", "()Lcom/futuretech/pdfreaderconverter/adapter/HomeFilesAdapter;", "homeFilesAdapter$delegate", "Lkotlin/Lazy;", "homeFilesBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityHomeFilesBinding;", "getHomeFilesBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityHomeFilesBinding;", "homeFilesBinding$delegate", "homeItemDialog", "Lcom/futuretech/pdfreaderconverter/dialog/HomeItemDialog;", "outputDirectory", "Ljava/io/File;", "addFile", "", "c", "Landroid/content/Context;", "f", "clearSearchBar", "clickAction", "clickItem", "action", "", "handleObserver", "list", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "openKeyboard", "removeFile", "searchAction", "searchFileArrayList", "setEditTextChangeListener", "setHomeTextWatcher", "setListener", "setToolbar", "showHomeItemDialog", "app_release"})
public final class HomeFiles extends com.futuretech.pdfreaderconverter.ui.base.BaseActivity {
    private com.futuretech.pdfreaderconverter.dialog.HomeItemDialog homeItemDialog;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.FileModel> fileModelArrayList;
    private final kotlin.Lazy homeFilesBinding$delegate = null;
    private final kotlin.Lazy homeFilesAdapter$delegate = null;
    private java.io.File outputDirectory;
    private java.util.HashMap _$_findViewCache;
    
    public HomeFiles() {
        super();
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.ActivityHomeFilesBinding getHomeFilesBinding() {
        return null;
    }
    
    private final com.futuretech.pdfreaderconverter.adapter.HomeFilesAdapter getHomeFilesAdapter() {
        return null;
    }
    
    private final void searchAction(java.util.List<com.futuretech.pdfreaderconverter.model.FileModel> searchFileArrayList, int action) {
    }
    
    private final void clickAction(com.futuretech.pdfreaderconverter.model.FileModel clickItem, int action) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setListener() {
    }
    
    private final void setToolbar() {
    }
    
    private final void clearSearchBar() {
    }
    
    private final void setEditTextChangeListener() {
    }
    
    private final void openKeyboard() {
    }
    
    private final void setHomeTextWatcher() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void handleObserver(java.util.List<com.futuretech.pdfreaderconverter.model.FileModel> list) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void showHomeItemDialog(com.futuretech.pdfreaderconverter.model.FileModel clickItem, int action) {
    }
    
    private final void removeFile(android.content.Context c, java.io.File f) {
    }
    
    private final void addFile(android.content.Context c, java.io.File f) {
    }
}