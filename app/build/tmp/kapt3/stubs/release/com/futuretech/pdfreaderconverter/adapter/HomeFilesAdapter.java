package com.futuretech.pdfreaderconverter.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.futuretech.pdfreaderconverter.databinding.ItemHomeBinding;
import com.futuretech.pdfreaderconverter.model.FileModel;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001bB?\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u001e\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\u0010\u000bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0007H\u0016J\u0016\u0010\u0017\u001a\u00020\b2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R \u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/HomeFilesAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/widget/Filterable;", "clickAction", "Lkotlin/Function2;", "", "", "searchAction", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "homeFileArrayList", "Ljava/util/ArrayList;", "getFilter", "Landroid/widget/Filter;", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAdapterList", "setHasStableIds", "hasStableIds", "", "HomeFilesViewHolder", "app_release"})
public final class HomeFilesAdapter extends androidx.recyclerview.widget.ListAdapter<com.futuretech.pdfreaderconverter.model.FileModel, androidx.recyclerview.widget.RecyclerView.ViewHolder> implements android.widget.Filterable {
    private final kotlin.jvm.functions.Function2<com.futuretech.pdfreaderconverter.model.FileModel, java.lang.Integer, kotlin.Unit> clickAction = null;
    private final kotlin.jvm.functions.Function2<java.util.List<com.futuretech.pdfreaderconverter.model.FileModel>, java.lang.Integer, kotlin.Unit> searchAction = null;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.FileModel> homeFileArrayList;
    
    public HomeFilesAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.futuretech.pdfreaderconverter.model.FileModel, ? super java.lang.Integer, kotlin.Unit> clickAction, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.util.List<com.futuretech.pdfreaderconverter.model.FileModel>, ? super java.lang.Integer, kotlin.Unit> searchAction) {
        super(null);
    }
    
    public final void setAdapterList(@org.jetbrains.annotations.Nullable()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.FileModel> homeFileArrayList) {
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
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/HomeFilesAdapter$HomeFilesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/futuretech/pdfreaderconverter/databinding/ItemHomeBinding;", "(Lcom/futuretech/pdfreaderconverter/adapter/HomeFilesAdapter;Lcom/futuretech/pdfreaderconverter/databinding/ItemHomeBinding;)V", "bindItems", "", "fileModel", "Lcom/futuretech/pdfreaderconverter/model/FileModel;", "app_release"})
    public final class HomeFilesViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.futuretech.pdfreaderconverter.databinding.ItemHomeBinding binding = null;
        
        public HomeFilesViewHolder(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.databinding.ItemHomeBinding binding) {
            super(null);
        }
        
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.model.FileModel fileModel) {
        }
    }
}