package com.futuretech.pdfreaderconverter.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.DialogSaveAsPdfBinding;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.FileModel;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 &2\u00020\u0001:\u0001&B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\u0002\u0010\tJ$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\bH\u0016J\b\u0010\"\u001a\u00020\bH\u0016J\u001a\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010%\u001a\u00020\bH\u0002R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/SaveAsPdfDialog;", "Landroidx/fragment/app/DialogFragment;", "fileModelObj", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "clickAction", "Lkotlin/Function3;", "", "", "", "(Lcom/futuretech/pdfreaderconverter/model/FileModel;Lkotlin/jvm/functions/Function3;)V", "converterString", "dialogSaveAsPdfBinding", "Lcom/futuretech/pdfreaderconverter/databinding/DialogSaveAsPdfBinding;", "getDialogSaveAsPdfBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/DialogSaveAsPdfBinding;", "dialogSaveAsPdfBinding$delegate", "Lkotlin/Lazy;", "extension", "hasLowQuality", "", "hasMaxQuality", "hasMediumQuality", "hasPDFSelect", "hasRegularQuality", "quality", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onStart", "onViewCreated", "view", "setViews", "Companion", "app_debug"})
public final class SaveAsPdfDialog extends androidx.fragment.app.DialogFragment {
    private final com.futuretech.pdfreaderconverter.model.FileModel fileModelObj = null;
    private final kotlin.jvm.functions.Function3<com.futuretech.pdfreaderconverter.model.FileModel, java.lang.String, java.lang.Integer, kotlin.Unit> clickAction = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.dialog.SaveAsPdfDialog.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "SaveAsPdfDialog";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy dialogSaveAsPdfBinding$delegate = null;
    private boolean hasPDFSelect = true;
    private boolean hasLowQuality = false;
    private boolean hasMediumQuality = false;
    private boolean hasRegularQuality = true;
    private boolean hasMaxQuality = false;
    private java.lang.String converterString = "PDF";
    private int quality = 65;
    private java.lang.String extension = ".pdf";
    private java.util.HashMap _$_findViewCache;
    
    public SaveAsPdfDialog(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel fileModelObj, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super com.futuretech.pdfreaderconverter.model.FileModel, ? super java.lang.String, ? super java.lang.Integer, kotlin.Unit> clickAction) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.databinding.DialogSaveAsPdfBinding getDialogSaveAsPdfBinding() {
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
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setViews() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onPause() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/SaveAsPdfDialog$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}