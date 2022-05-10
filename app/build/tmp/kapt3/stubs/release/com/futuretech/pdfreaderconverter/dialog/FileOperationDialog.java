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
import com.futuretech.pdfreaderconverter.databinding.FileOperationDialogBinding;
import com.futuretech.pdfreaderconverter.model.FileModel;
import com.futuretech.pdfreaderconverter.model.PdfFile;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016J\u001a\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0017J\b\u0010 \u001a\u00020\tH\u0002R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\""}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/FileOperationDialog;", "Landroidx/fragment/app/DialogFragment;", "clickItem", "", "action", "", "clickAction", "Lkotlin/Function3;", "", "", "(Ljava/lang/Object;ILkotlin/jvm/functions/Function3;)V", "getAction", "()I", "getClickItem", "()Ljava/lang/Object;", "fileOperationDialogBinding", "Lcom/futuretech/pdfreaderconverter/databinding/FileOperationDialogBinding;", "getFileOperationDialogBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/FileOperationDialogBinding;", "fileOperationDialogBinding$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setDialogViews", "Companion", "app_release"})
public final class FileOperationDialog extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.Object clickItem = null;
    private final int action = 0;
    private final kotlin.jvm.functions.Function3<java.lang.Object, java.lang.Integer, java.lang.Boolean, kotlin.Unit> clickAction = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.dialog.FileOperationDialog.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "FileOperationDialog";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy fileOperationDialogBinding$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public FileOperationDialog(@org.jetbrains.annotations.NotNull()
    java.lang.Object clickItem, int action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<java.lang.Object, ? super java.lang.Integer, ? super java.lang.Boolean, kotlin.Unit> clickAction) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.Object getClickItem() {
        return null;
    }
    
    public final int getAction() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.databinding.FileOperationDialogBinding getFileOperationDialogBinding() {
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
    
    private final void setDialogViews() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/FileOperationDialog$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}