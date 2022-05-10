package com.futuretech.pdfreaderconverter.ui.camera;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.*;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Size;
import android.view.View;
import android.webkit.MimeTypeMap;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.camera.core.*;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.extension.*;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import com.futuretech.pdfreaderconverter.ui.editing.EditImageScreen;
import com.futuretech.pdfreaderconverter.ui.gallery.GalleryScreen;
import com.futuretech.pdfreaderconverter.utility.Constants;
import com.futuretech.pdfreaderconverter.utility.Logger;
import com.futuretech.pdfreaderconverter.utility.LuminosityAnalyzer;
import kotlinx.coroutines.Dispatchers;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import java.io.File;
import java.util.concurrent.Executors;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\"\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\r2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u001e\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u001e\u0010 \u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010!\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J-\u0010#\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f0%2\u0006\u0010&\u001a\u00020\'H\u0016\u00a2\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\rH\u0014J\b\u0010*\u001a\u00020\rH\u0002J\b\u0010+\u001a\u00020\rH\u0002J\u0012\u0010,\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010\u001fH\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0003J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020\rH\u0002J\b\u00103\u001a\u00020\rH\u0002R$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u00064"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/camera/CameraScreen;", "Lcom/futuretech/pdfreaderconverter/ui/camera/BaseCamera;", "Lpub/devrel/easypermissions/EasyPermissions$PermissionCallbacks;", "Lpub/devrel/easypermissions/EasyPermissions$RationaleCallbacks;", "()V", "galleryLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "getGalleryLauncher", "()Landroidx/activity/result/ActivityResultLauncher;", "setGalleryLauncher", "(Landroidx/activity/result/ActivityResultLauncher;)V", "bindCameraUseCases", "", "clearListValues", "deleteQueueImage", "onActivityResult", "requestCode", "", "resultCode", "data", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPermissionsDenied", "perms", "", "", "onPermissionsGranted", "onRationaleAccepted", "onRationaleDenied", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "requestGalleryPermission", "setFlash", "setImageQueueData", "path", "setListener", "setToolbar", "startCamera", "startEditImageScreen", "startGalleryScreen", "updateCameraUi", "app_release"})
public final class CameraScreen extends com.futuretech.pdfreaderconverter.ui.camera.BaseCamera implements pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks, pub.devrel.easypermissions.EasyPermissions.RationaleCallbacks {
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    private androidx.activity.result.ActivityResultLauncher<android.content.Intent> galleryLauncher;
    private java.util.HashMap _$_findViewCache;
    
    public CameraScreen() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void startCamera() {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    private final void updateCameraUi() {
    }
    
    private final void startEditImageScreen() {
    }
    
    private final void clearListValues() {
    }
    
    private final void bindCameraUseCases() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void setFlash() {
    }
    
    private final void deleteQueueImage() {
    }
    
    private final void setImageQueueData(java.lang.String path) {
    }
    
    private final void requestGalleryPermission() {
    }
    
    private final void setListener() {
    }
    
    private final void startGalleryScreen() {
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    private final void setToolbar() {
    }
    
    @java.lang.Override()
    public void onPermissionsGranted(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    @java.lang.Override()
    public void onPermissionsDenied(int requestCode, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> perms) {
    }
    
    @java.lang.Override()
    public void onRationaleAccepted(int requestCode) {
    }
    
    @java.lang.Override()
    public void onRationaleDenied(int requestCode) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.activity.result.ActivityResultLauncher<android.content.Intent> getGalleryLauncher() {
        return null;
    }
    
    public final void setGalleryLauncher(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResultLauncher<android.content.Intent> p0) {
    }
}