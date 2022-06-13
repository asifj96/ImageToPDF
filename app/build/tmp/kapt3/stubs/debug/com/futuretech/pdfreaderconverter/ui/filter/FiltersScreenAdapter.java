package com.futuretech.pdfreaderconverter.ui.filter;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.model.FilterScreenModel;
import com.google.android.material.card.MaterialCardView;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0001\u0017B\u001f\u0012\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u001c\u0010\u0013\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0016R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0018"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/filter/FiltersScreenAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/futuretech/pdfreaderconverter/model/FilterScreenModel;", "Lcom/futuretech/pdfreaderconverter/ui/filter/FiltersScreenAdapter$FiltersViewHolder;", "clickItem", "Lkotlin/Function2;", "", "", "(Lkotlin/jvm/functions/Function2;)V", "colorFilter", "Lcom/futuretech/pdfreaderconverter/ui/filter/ColorFilters;", "selectedPos", "getSelectedPos", "()I", "setSelectedPos", "(I)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "FiltersViewHolder", "app_debug"})
public final class FiltersScreenAdapter extends androidx.recyclerview.widget.ListAdapter<com.futuretech.pdfreaderconverter.model.FilterScreenModel, com.futuretech.pdfreaderconverter.ui.filter.FiltersScreenAdapter.FiltersViewHolder> {
    private final kotlin.jvm.functions.Function2<com.futuretech.pdfreaderconverter.model.FilterScreenModel, java.lang.Integer, kotlin.Unit> clickItem = null;
    private final com.futuretech.pdfreaderconverter.ui.filter.ColorFilters colorFilter = null;
    private int selectedPos = 0;
    
    public FiltersScreenAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super com.futuretech.pdfreaderconverter.model.FilterScreenModel, ? super java.lang.Integer, kotlin.Unit> clickItem) {
        super(null);
    }
    
    public final int getSelectedPos() {
        return 0;
    }
    
    public final void setSelectedPos(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.futuretech.pdfreaderconverter.ui.filter.FiltersScreenAdapter.FiltersViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.ui.filter.FiltersScreenAdapter.FiltersViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\r0\u0011J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/filter/FiltersScreenAdapter$FiltersViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/futuretech/pdfreaderconverter/ui/filter/FiltersScreenAdapter;Landroid/view/View;)V", "iVSelectedFilter", "Landroid/widget/ImageView;", "ivEffectView", "mCVItem", "Lcom/google/android/material/card/MaterialCardView;", "tvEffectName", "Landroid/widget/TextView;", "bindItems", "", "filterModel", "Lcom/futuretech/pdfreaderconverter/model/FilterScreenModel;", "function", "Lkotlin/Function1;", "getFilter", "Landroid/graphics/Bitmap;", "bitmap", "app_debug"})
    public final class FiltersViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.ImageView ivEffectView;
        private android.widget.ImageView iVSelectedFilter;
        private android.widget.TextView tvEffectName;
        private com.google.android.material.card.MaterialCardView mCVItem;
        
        public FiltersViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.model.FilterScreenModel filterModel, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.futuretech.pdfreaderconverter.model.FilterScreenModel, kotlin.Unit> function) {
        }
        
        private final android.graphics.Bitmap getFilter(android.graphics.Bitmap bitmap) {
            return null;
        }
    }
}