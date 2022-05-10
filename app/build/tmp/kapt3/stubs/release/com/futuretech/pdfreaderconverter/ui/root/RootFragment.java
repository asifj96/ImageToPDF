package com.futuretech.pdfreaderconverter.ui.root;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.adapter.RootItemAdapter;
import com.futuretech.pdfreaderconverter.databinding.FragmentRootBinding;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.ui.base.BaseFragment;
import com.futuretech.pdfreaderconverter.ui.camera.CameraScreen;
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen;
import com.futuretech.pdfreaderconverter.ui.gallery.GalleryScreen;
import com.futuretech.pdfreaderconverter.ui.home.HomeFiles;
import com.futuretech.pdfreaderconverter.utility.Logger;
import java.io.File;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010&\u001a\u00020\u00142\b\u0010\'\u001a\u0004\u0018\u00010(H\u0002J\b\u0010)\u001a\u00020\u0014H\u0002J\b\u0010*\u001a\u00020\u0014H\u0002J\b\u0010+\u001a\u00020\u0014H\u0002J\b\u0010,\u001a\u00020\u0014H\u0002J\b\u0010-\u001a\u00020\u0014H\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002R$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00060"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/root/RootFragment;", "Lcom/futuretech/pdfreaderconverter/ui/base/BaseFragment;", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "()V", "galleryLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getGalleryLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setGalleryLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "imageQueueArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "imageQueueObj", "mBinding", "Lcom/futuretech/pdfreaderconverter/databinding/FragmentRootBinding;", "rootItemAdapter", "Lcom/futuretech/pdfreaderconverter/adapter/RootItemAdapter;", "deleteQueueImage", "", "handleClick", "itemPos", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onMenuItemClick", "", "item", "Landroid/view/MenuItem;", "onViewCreated", "view", "setImageQueueData", "path", "", "setListener", "setRootItemAdapter", "setToolbar", "startCameraScreen", "startEditImageScreen", "startGalleryScreen", "startHomeScreen", "app_release"})
public final class RootFragment extends com.futuretech.pdfreaderconverter.ui.base.BaseFragment implements androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener {
    private com.futuretech.pdfreaderconverter.model.ImageQueue imageQueueObj;
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList;
    private com.futuretech.pdfreaderconverter.databinding.FragmentRootBinding mBinding;
    private com.futuretech.pdfreaderconverter.adapter.RootItemAdapter rootItemAdapter;
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> galleryLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public RootFragment() {
        super();
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
    
    private final void setListener() {
    }
    
    private final void setToolbar() {
    }
    
    private final void setRootItemAdapter() {
    }
    
    private final void handleClick(int itemPos) {
    }
    
    private final void startGalleryScreen() {
    }
    
    private final void startCameraScreen() {
    }
    
    private final void startHomeScreen() {
    }
    
    @java.lang.Override()
    public boolean onMenuItemClick(@org.jetbrains.annotations.Nullable()
    android.view.MenuItem item) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getGalleryLauncher() {
        return null;
    }
    
    public final void setGalleryLauncher(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
    
    private final void startEditImageScreen() {
    }
    
    private final void setImageQueueData(java.lang.String path) {
    }
    
    private final void deleteQueueImage() {
    }
}