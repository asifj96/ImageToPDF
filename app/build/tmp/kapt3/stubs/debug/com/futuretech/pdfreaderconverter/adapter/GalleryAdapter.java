package com.futuretech.pdfreaderconverter.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.futuretech.pdfreaderconverter.databinding.ItemGalleryBinding;
import com.futuretech.pdfreaderconverter.model.GalleryModel;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/GalleryAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/futuretech/pdfreaderconverter/model/GalleryModel;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "getItemId", "", "position", "", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setHasStableIds", "hasStableIds", "", "GalleryViewHolder", "app_debug"})
public final class GalleryAdapter extends androidx.recyclerview.widget.ListAdapter<com.futuretech.pdfreaderconverter.model.GalleryModel, androidx.recyclerview.widget.RecyclerView.ViewHolder> {
    
    public GalleryAdapter() {
        super(null);
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
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @java.lang.Override()
    public void setHasStableIds(boolean hasStableIds) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/GalleryAdapter$GalleryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/futuretech/pdfreaderconverter/databinding/ItemGalleryBinding;", "(Lcom/futuretech/pdfreaderconverter/adapter/GalleryAdapter;Lcom/futuretech/pdfreaderconverter/databinding/ItemGalleryBinding;)V", "bindItems", "", "gallery", "Lcom/futuretech/pdfreaderconverter/model/GalleryModel;", "app_debug"})
    public final class GalleryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final com.futuretech.pdfreaderconverter.databinding.ItemGalleryBinding binding = null;
        
        public GalleryViewHolder(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.databinding.ItemGalleryBinding binding) {
            super(null);
        }
        
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.model.GalleryModel gallery) {
        }
    }
}