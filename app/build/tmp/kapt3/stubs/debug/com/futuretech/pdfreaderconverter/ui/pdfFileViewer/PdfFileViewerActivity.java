package com.futuretech.pdfreaderconverter.ui.pdfFileViewer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.ActivityPdfFileViewerBinding;
import com.futuretech.pdfreaderconverter.dialog.PdfPasswordDialog;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.PdfFile;
import com.futuretech.pdfreaderconverter.ui.base.BaseActivity;
import com.futuretech.pdfreaderconverter.utility.Logger;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.shockwave.pdfium.PdfPasswordException;
import kotlinx.coroutines.Dispatchers;
import java.io.File;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u00103\u001a\u000204H\u0016J\n\u00105\u001a\u0004\u0018\u00010\u0012H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0010H\u0002J\n\u00107\u001a\u0004\u0018\u000102H\u0002J\n\u00108\u001a\u0004\u0018\u00010(H\u0002J\b\u00109\u001a\u00020\u0017H\u0002J\u0010\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\nH\u0016J\b\u0010<\u001a\u000204H\u0002J\u0012\u0010=\u001a\u0002042\b\u0010>\u001a\u0004\u0018\u00010?H\u0014J\u0010\u0010@\u001a\u0002042\u0006\u0010;\u001a\u00020\nH\u0016J\u0018\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\nH\u0016J\u001a\u0010D\u001a\u0002042\u0006\u0010B\u001a\u00020\n2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u001a\u0010G\u001a\u0002042\u0006\u0010H\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102H\u0002J\b\u0010I\u001a\u000204H\u0002J\b\u0010J\u001a\u000204H\u0002J\b\u0010K\u001a\u000204H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u000e\u0010$\u001a\u00020%X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(0\'j\b\u0012\u0004\u0012\u00020(`)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010-\u001a\u00020.\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006L"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/pdfFileViewer/PdfFileViewerActivity;", "Lcom/futuretech/pdfreaderconverter/ui/base/BaseActivity;", "Lcom/github/barteksc/pdfviewer/listener/OnPageChangeListener;", "Lcom/github/barteksc/pdfviewer/listener/OnPageErrorListener;", "Lcom/github/barteksc/pdfviewer/listener/OnLoadCompleteListener;", "Lcom/github/barteksc/pdfviewer/listener/OnRenderListener;", "()V", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "currentPage", "", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "edtPass", "", "fileModelObj", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "fileObj", "", "filePath", "isInitialRender", "", "isNightMode", "Ljava/lang/Boolean;", "isOutsideApp", "isSwipe", "job", "Lkotlinx/coroutines/CompletableJob;", "mBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityPdfFileViewerBinding;", "getMBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityPdfFileViewerBinding;", "mBinding$delegate", "Lkotlin/Lazy;", "outputDirectory", "Ljava/io/File;", "pdfFileArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/PdfFile;", "Lkotlin/collections/ArrayList;", "pdfName", "pdfPasswordDialog", "Lcom/futuretech/pdfreaderconverter/dialog/PdfPasswordDialog;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "uri", "Landroid/net/Uri;", "finish", "", "getFileModelObj", "getFilePath", "getFileUri", "getPdfFileObj", "getPdfFragment", "loadComplete", "nbPages", "loadPdfFile", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInitiallyRendered", "onPageChanged", "page", "pageCount", "onPageError", "t", "", "reloadPDF", "password", "setListener", "setToolbar", "showPdfPasswordDialog", "app_debug"})
public final class PdfFileViewerActivity extends com.futuretech.pdfreaderconverter.ui.base.BaseActivity implements com.github.barteksc.pdfviewer.listener.OnPageChangeListener, com.github.barteksc.pdfviewer.listener.OnPageErrorListener, com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener, com.github.barteksc.pdfviewer.listener.OnRenderListener {
    private boolean isOutsideApp = false;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.PdfFile> pdfFileArrayList;
    private java.lang.String filePath = "";
    private java.lang.String pdfName = "";
    private java.lang.String edtPass = "";
    private android.net.Uri uri;
    private com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog;
    private java.lang.Boolean isSwipe = false;
    private java.lang.Boolean isNightMode = false;
    private int currentPage = 0;
    private java.io.File outputDirectory;
    private com.futuretech.pdfreaderconverter.model.FileModel fileModelObj;
    private java.lang.Object fileObj;
    private kotlinx.coroutines.CompletableJob job;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private boolean isInitialRender = false;
    private final kotlin.Lazy mBinding$delegate = null;
    private com.futuretech.pdfreaderconverter.dialog.PdfPasswordDialog pdfPasswordDialog;
    private java.util.HashMap _$_findViewCache;
    
    public PdfFileViewerActivity() {
        super();
    }
    
    public final int getCurrentPage() {
        return 0;
    }
    
    public final void setCurrentPage(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.CoroutineScope getScope() {
        return null;
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.ActivityPdfFileViewerBinding getMBinding() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setListener() {
    }
    
    private final com.futuretech.pdfreaderconverter.model.PdfFile getPdfFileObj() {
        return null;
    }
    
    private final java.lang.String getFilePath() {
        return null;
    }
    
    private final com.futuretech.pdfreaderconverter.model.FileModel getFileModelObj() {
        return null;
    }
    
    private final boolean getPdfFragment() {
        return false;
    }
    
    private final android.net.Uri getFileUri() {
        return null;
    }
    
    private final void setToolbar() {
    }
    
    private final void loadPdfFile() {
    }
    
    @java.lang.Override()
    public void finish() {
    }
    
    @java.lang.Override()
    public void onPageChanged(int page, int pageCount) {
    }
    
    @java.lang.Override()
    public void onPageError(int page, @org.jetbrains.annotations.Nullable()
    java.lang.Throwable t) {
    }
    
    @java.lang.Override()
    public void loadComplete(int nbPages) {
    }
    
    @java.lang.Override()
    public void onInitiallyRendered(int nbPages) {
    }
    
    private final void showPdfPasswordDialog() {
    }
    
    private final void reloadPDF(java.lang.String password, android.net.Uri uri) {
    }
}