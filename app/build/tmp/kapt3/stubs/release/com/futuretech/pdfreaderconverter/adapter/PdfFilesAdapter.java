package com.futuretech.pdfreaderconverter.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.ItemListPdfFilesBinding;
import com.futuretech.pdfreaderconverter.model.PdfFile;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001cBG\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012 \u0010\t\u001a\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\u0002\u0010\fJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0016\u0010\u0018\u001a\u00020\b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eJ\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R&\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R(\u0010\t\u001a\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/PdfFilesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/futuretech/pdfreaderconverter/model/PdfFile;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "clickAction", "Lkotlin/Function3;", "", "", "searchAction", "Lkotlin/Function2;", "", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;)V", "documentFileArrayList", "Ljava/util/ArrayList;", "getFilter", "Landroid/widget/Filter;", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAdapterList", "setHasStableIds", "hasStableIds", "", "DocumentFilesViewHolder", "app_release"})
public final class PdfFilesAdapter extends androidx.recyclerview.widget.ListAdapter<com.futuretech.pdfreaderconverter.model.PdfFile, androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.widget.Filterable {
    private final kotlin.jvm.functions.Function3<com.futuretech.pdfreaderconverter.model.PdfFile, java.lang.Integer, java.lang.Integer, kotlin.Unit> clickAction = null;
    private final kotlin.jvm.functions.Function2<java.util.List<com.futuretech.pdfreaderconverter.model.PdfFile>, java.lang.Integer, kotlin.Unit> searchAction = null;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.PdfFile> documentFileArrayList;
    
    public PdfFilesAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super com.futuretech.pdfreaderconverter.model.PdfFile, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> clickAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.util.List<com.futuretech.pdfreaderconverter.model.PdfFile>, ? super java.lang.Integer, kotlin.Unit> searchAction) {
        super(null);
    }
    
    public final void setAdapterList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.PdfFile> documentFileArrayList) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.recyclerview.widget.RecyclerView.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
    
    @java.lang.Override()
    public void setHasStableIds(boolean hasStableIds) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/PdfFilesAdapter$DocumentFilesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/futuretech/pdfreaderconverter/databinding/ItemListPdfFilesBinding;", "(Lcom/futuretech/pdfreaderconverter/adapter/PdfFilesAdapter;Lcom/futuretech/pdfreaderconverter/databinding/ItemListPdfFilesBinding;)V", "bindItems", "", "documentFile", "Lcom/futuretech/pdfreaderconverter/model/PdfFile;", "app_release"})
    public final class DocumentFilesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.futuretech.pdfreaderconverter.databinding.ItemListPdfFilesBinding binding = null;
        
        public DocumentFilesViewHolder(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.databinding.ItemListPdfFilesBinding binding) {
            super(null);
        }
        
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.model.PdfFile documentFile) {
        }
    }
}