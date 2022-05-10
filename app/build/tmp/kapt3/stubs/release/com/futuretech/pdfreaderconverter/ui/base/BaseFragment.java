package com.futuretech.pdfreaderconverter.ui.base;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel;
import com.futuretech.pdfreaderconverter.utility.Constants;
import com.futuretech.pdfreaderconverter.utility.Logger;
import pub.devrel.easypermissions.EasyPermissions;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J-\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00142\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00110\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016\u00a2\u0006\u0002\u0010\u001bJ\u0006\u0010\u001c\u001a\u00020\nJ\u001a\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\n\u0010\u001e\u001a\u00020\r*\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "imageQueueViewModel", "Lcom/futuretech/pdfreaderconverter/data/viewmodel/ImageQueueViewModel;", "getImageQueueViewModel", "()Lcom/futuretech/pdfreaderconverter/data/viewmodel/ImageQueueViewModel;", "imageQueueViewModel$delegate", "Lkotlin/Lazy;", "checkUserRequestedDontAskAgain", "", "displayNeverAskAgainDialog", "getRatinaleDisplayStatus", "", "context", "Landroid/content/Context;", "permission", "", "navigate", "actionId", "", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermission", "setShouldShowStatus", "hasStoragePermission", "app_release"})
public class BaseFragment extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy imageQueueViewModel$delegate = null;
    private java.util.HashMap _$_findViewCache;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel getImageQueueViewModel() {
        return null;
    }
    
    public final void navigate(int actionId) {
    }
    
    public final void requestPermission() {
    }
    
    private final void displayNeverAskAgainDialog() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    private final void checkUserRequestedDontAskAgain() {
    }
    
    private final void setShouldShowStatus(android.content.Context context, java.lang.String permission) {
    }
    
    public final boolean hasStoragePermission(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$hasStoragePermission) {
        return false;
    }
    
    public final boolean getRatinaleDisplayStatus(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String permission) {
        return false;
    }
}