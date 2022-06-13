package com.futuretech.pdfreaderconverter.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.databinding.LayoutRootItemBinding;
import com.futuretech.pdfreaderconverter.model.RootItem;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\t2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\bH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/RootItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/futuretech/pdfreaderconverter/adapter/RootItemAdapter$RootItemViewHolder;", "rootItemList", "", "Lcom/futuretech/pdfreaderconverter/model/RootItem;", "clickItem", "Lkotlin/Function1;", "", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "RootItemViewHolder", "app_release"})
public final class RootItemAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.futuretech.pdfreaderconverter.adapter.RootItemAdapter.RootItemViewHolder> {
    private java.util.List<com.futuretech.pdfreaderconverter.model.RootItem> rootItemList;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> clickItem = null;
    
    public RootItemAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.futuretech.pdfreaderconverter.model.RootItem> rootItemList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> clickItem) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.futuretech.pdfreaderconverter.adapter.RootItemAdapter.RootItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.futuretech.pdfreaderconverter.adapter.RootItemAdapter.RootItemViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/futuretech/pdfreaderconverter/adapter/RootItemAdapter$RootItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/futuretech/pdfreaderconverter/databinding/LayoutRootItemBinding;", "(Lcom/futuretech/pdfreaderconverter/adapter/RootItemAdapter;Lcom/futuretech/pdfreaderconverter/databinding/LayoutRootItemBinding;)V", "bindItems", "", "rootItem", "Lcom/futuretech/pdfreaderconverter/model/RootItem;", "app_release"})
    public final class RootItemViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private com.futuretech.pdfreaderconverter.databinding.LayoutRootItemBinding binding;
        
        public RootItemViewHolder(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.databinding.LayoutRootItemBinding binding) {
            super(null);
        }
        
        public final void bindItems(@org.jetbrains.annotations.NotNull()
        com.futuretech.pdfreaderconverter.model.RootItem rootItem) {
        }
    }
}