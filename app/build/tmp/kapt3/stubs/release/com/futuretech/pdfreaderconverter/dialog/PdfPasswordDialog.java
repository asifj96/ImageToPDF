package com.futuretech.pdfreaderconverter.dialog;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.DialogFragment;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.DialogPdfPasswordBinding;
import com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u001a\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\b\u0010\u001a\u001a\u00020\u0005H\u0002J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/PdfPasswordDialog;", "Landroidx/fragment/app/DialogFragment;", "clickAction", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "dialogPasswordBinding", "Lcom/futuretech/pdfreaderconverter/databinding/DialogPdfPasswordBinding;", "getDialogPasswordBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/DialogPdfPasswordBinding;", "dialogPasswordBinding$delegate", "Lkotlin/Lazy;", "pdfFileViewerActivity", "Lcom/futuretech/pdfreaderconverter/ui/pdfFileViewer/PdfFileViewerActivity;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "openKeyboard", "setData", "pdfViewerActivity", "Companion", "app_release"})
public final class PdfPasswordDialog extends androidx.fragment.app.DialogFragment {
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> clickAction = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.dialog.PdfPasswordDialog.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "PdfPasswordDialog";
    private com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity pdfFileViewerActivity;
    private final kotlin.Lazy dialogPasswordBinding$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public PdfPasswordDialog(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> clickAction) {
        super();
    }
    
    private final com.futuretech.pdfreaderconverter.databinding.DialogPdfPasswordBinding getDialogPasswordBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.Q)
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void openKeyboard() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.ui.pdfFileViewer.PdfFileViewerActivity pdfViewerActivity) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/PdfPasswordDialog$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}