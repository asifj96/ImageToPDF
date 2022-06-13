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

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/filter/DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/futuretech/pdfreaderconverter/model/FilterScreenModel;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_release"})
final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.futuretech.pdfreaderconverter.model.FilterScreenModel> {
    
    public DiffCallback() {
        super();
    }
    
    @java.lang.Override()
    public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FilterScreenModel oldItem, @org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FilterScreenModel newItem) {
        return false;
    }
    
    @java.lang.Override()
    public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FilterScreenModel oldItem, @org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.model.FilterScreenModel newItem) {
        return false;
    }
}