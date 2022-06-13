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
import com.futuretech.pdfreaderconverter.databinding.ItemHomeDialogBinding;
import com.futuretech.pdfreaderconverter.model.FileModel;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001&B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u00c2\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0001J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u001a\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0017J\b\u0010#\u001a\u00020\bH\u0002J\t\u0010$\u001a\u00020%H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\'"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/HomeItemDialog;", "Landroidx/fragment/app/DialogFragment;", "clickItem", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "action", "", "clickAction", "Lkotlin/Function2;", "", "(Lcom/futuretech/pdfreaderconverter/model/FileModel;ILkotlin/jvm/functions/Function2;)V", "getAction", "()I", "getClickItem", "()Lcom/futuretech/pdfreaderconverter/model/FileModel;", "itemHomeDialogBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ItemHomeDialogBinding;", "getItemHomeDialogBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ItemHomeDialogBinding;", "itemHomeDialogBinding$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "copy", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onViewCreated", "view", "setDialogViews", "toString", "", "Companion", "app_debug"})
public final class HomeItemDialog extends androidx.fragment.app.DialogFragment {
    @org.jetbrains.annotations.NotNull()
    private final com.futuretech.pdfreaderconverter.model.FileModel clickItem = null;
    private final int action = 0;
    private final kotlin.jvm.functions.Function2<com.futuretech.pdfreaderconverter.model.FileModel, java.lang.Integer, kotlin.Unit> clickAction = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.dialog.HomeItemDialog.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "HomeItemDialog";
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy itemHomeDialogBinding$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.dialog.HomeItemDialog copy(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel clickItem, int action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.futuretech.pdfreaderconverter.model.FileModel, ? super java.lang.Integer, kotlin.Unit> clickAction) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public HomeItemDialog(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FileModel clickItem, int action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.futuretech.pdfreaderconverter.model.FileModel, ? super java.lang.Integer, kotlin.Unit> clickAction) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.model.FileModel component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.model.FileModel getClickItem() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int getAction() {
        return 0;
    }
    
    private final kotlin.jvm.functions.Function2<com.futuretech.pdfreaderconverter.model.FileModel, java.lang.Integer, kotlin.Unit> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.databinding.ItemHomeDialogBinding getItemHomeDialogBinding() {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/futuretech/pdfreaderconverter/dialog/HomeItemDialog$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}