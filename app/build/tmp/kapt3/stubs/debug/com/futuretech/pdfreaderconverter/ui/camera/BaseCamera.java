package com.futuretech.pdfreaderconverter.ui.camera;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.util.Log;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.*;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.futuretech.pdfreaderconverter.data.viewmodel.FileViewModel;
import com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel;
import com.futuretech.pdfreaderconverter.databinding.ActivityCameraScreenBinding;
import com.futuretech.pdfreaderconverter.model.ImageQueue;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u008a\u00012\u00020\u0001:\u0002\u008a\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010y\u001a\u00020\u00162\u0006\u0010z\u001a\u00020\u00162\u0006\u0010{\u001a\u00020\u0016H\u0004J \u0010|\u001a\u00020W2\u0006\u0010}\u001a\u00020W2\u0006\u0010~\u001a\u00020!2\u0006\u0010\u007f\u001a\u00020!H\u0004J\n\u0010\u0080\u0001\u001a\u00030\u0081\u0001H\u0005J\n\u0010\u0082\u0001\u001a\u00030\u0081\u0001H\u0005J\n\u0010\u0083\u0001\u001a\u00030\u0081\u0001H\u0004J\u0012\u0010\u0084\u0001\u001a\u00030\u0081\u00012\u0006\u0010m\u001a\u00020nH\u0004J\n\u0010\u0085\u0001\u001a\u00030\u0081\u0001H\u0004J#\u0010\u0086\u0001\u001a\u00030\u0081\u0001*\u00030\u0087\u00012\u0011\b\u0004\u0010\u0088\u0001\u001a\n\u0012\u0005\u0012\u00030\u0081\u00010\u0089\u0001H\u0082\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8DX\u0084\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\u00020\u001c8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020!X\u0084D\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020%X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\'\"\u0004\b,\u0010)R\u001a\u0010-\u001a\u00020%X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\'\"\u0004\b/\u0010)R\u001c\u00100\u001a\u0004\u0018\u000101X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001c\u0010<\u001a\u0004\u0018\u00010=X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR \u0010B\u001a\b\u0012\u0004\u0012\u00020D0CX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010DX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001b\u0010N\u001a\u00020O8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\bR\u0010\u000e\u001a\u0004\bP\u0010QR\u001a\u0010S\u001a\u00020\u0016X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0018\"\u0004\bU\u0010\u001aR\u001a\u0010V\u001a\u00020WX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0014\u0010\\\u001a\u00020!X\u0084D\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u0010#R\u001c\u0010^\u001a\u0004\u0018\u00010_X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001c\u0010d\u001a\u0004\u0018\u00010eX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u000e\u0010j\u001a\u00020kX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010l\u001a\u00020kX\u0082D\u00a2\u0006\u0002\n\u0000R\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR \u0010s\u001a\b\u0012\u0004\u0012\u00020n0tX\u0084.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010x\u00a8\u0006\u008b\u0001"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/camera/BaseCamera;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "camera", "Landroidx/camera/core/Camera;", "getCamera", "()Landroidx/camera/core/Camera;", "setCamera", "(Landroidx/camera/core/Camera;)V", "cameraBinding", "Lcom/futuretech/pdfreaderconverter/databinding/ActivityCameraScreenBinding;", "getCameraBinding", "()Lcom/futuretech/pdfreaderconverter/databinding/ActivityCameraScreenBinding;", "cameraBinding$delegate", "Lkotlin/Lazy;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "getCameraExecutor", "()Ljava/util/concurrent/ExecutorService;", "setCameraExecutor", "(Ljava/util/concurrent/ExecutorService;)V", "captureCounter", "", "getCaptureCounter", "()I", "setCaptureCounter", "(I)V", "fileViewModel", "Lcom/futuretech/pdfreaderconverter/data/viewmodel/FileViewModel;", "getFileViewModel", "()Lcom/futuretech/pdfreaderconverter/data/viewmodel/FileViewModel;", "fileViewModel$delegate", "filename", "", "getFilename", "()Ljava/lang/String;", "hasBatchMode", "", "getHasBatchMode", "()Z", "setHasBatchMode", "(Z)V", "hasFlashMode", "getHasFlashMode", "setHasFlashMode", "hasGridMode", "getHasGridMode", "setHasGridMode", "imageAnalyzer", "Landroidx/camera/core/ImageAnalysis;", "getImageAnalyzer", "()Landroidx/camera/core/ImageAnalysis;", "setImageAnalyzer", "(Landroidx/camera/core/ImageAnalysis;)V", "imageCapture", "Landroidx/camera/core/ImageCapture;", "getImageCapture", "()Landroidx/camera/core/ImageCapture;", "setImageCapture", "(Landroidx/camera/core/ImageCapture;)V", "imageCaptureBuilder", "Landroidx/camera/core/ImageCapture$Builder;", "getImageCaptureBuilder", "()Landroidx/camera/core/ImageCapture$Builder;", "setImageCaptureBuilder", "(Landroidx/camera/core/ImageCapture$Builder;)V", "imageQueueArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "getImageQueueArrayList", "()Ljava/util/ArrayList;", "setImageQueueArrayList", "(Ljava/util/ArrayList;)V", "imageQueueObj", "getImageQueueObj", "()Lcom/futuretech/pdfreaderconverter/model/ImageQueue;", "setImageQueueObj", "(Lcom/futuretech/pdfreaderconverter/model/ImageQueue;)V", "imageQueueViewModel", "Lcom/futuretech/pdfreaderconverter/data/viewmodel/ImageQueueViewModel;", "getImageQueueViewModel", "()Lcom/futuretech/pdfreaderconverter/data/viewmodel/ImageQueueViewModel;", "imageQueueViewModel$delegate", "lensFacing", "getLensFacing", "setLensFacing", "outputDirectory", "Ljava/io/File;", "getOutputDirectory", "()Ljava/io/File;", "setOutputDirectory", "(Ljava/io/File;)V", "photoExtension", "getPhotoExtension", "preview", "Landroidx/camera/core/Preview;", "getPreview", "()Landroidx/camera/core/Preview;", "setPreview", "(Landroidx/camera/core/Preview;)V", "previewBuilder", "Landroidx/camera/core/Preview$Builder;", "getPreviewBuilder", "()Landroidx/camera/core/Preview$Builder;", "setPreviewBuilder", "(Landroidx/camera/core/Preview$Builder;)V", "ratioValue1", "", "ratioValue2", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "uris", "", "getUris", "()Ljava/util/List;", "setUris", "(Ljava/util/List;)V", "aspectRatio", "width", "height", "createFile", "baseFolder", "format", "extension", "enableFocusFeature", "", "enableZoomFeature", "hideBackArrowThumbnailWidget", "setGalleryThumbnail", "showBackArrowThumbnailWidget", "afterMeasured", "Landroid/view/View;", "block", "Lkotlin/Function0;", "Companion", "app_debug"})
public class BaseCamera extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy cameraBinding$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy fileViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy imageQueueViewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.futuretech.pdfreaderconverter.model.ImageQueue imageQueueObj;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> imageQueueArrayList;
    @org.jetbrains.annotations.Nullable()
    private android.net.Uri uri;
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.ui.camera.BaseCamera.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "CameraX";
    private boolean hasBatchMode = false;
    private boolean hasGridMode = false;
    private boolean hasFlashMode = false;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.Camera camera;
    protected java.util.List<? extends android.net.Uri> uris;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.ImageAnalysis imageAnalyzer;
    private int lensFacing = androidx.camera.core.CameraSelector.LENS_FACING_BACK;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.Preview.Builder previewBuilder;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.Preview preview;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.ImageCapture.Builder imageCaptureBuilder;
    private int captureCounter = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String filename = "yyyy-MM-dd-HH-mm-ss-SSS";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String photoExtension = ".jpg";
    private final double ratioValue1 = 1.3333333333333333;
    private final double ratioValue2 = 1.7777777777777777;
    
    /**
     * Blocking camera operations are performed using this executor
     */
    protected java.util.concurrent.ExecutorService cameraExecutor;
    @org.jetbrains.annotations.Nullable()
    private androidx.camera.core.ImageCapture imageCapture;
    protected java.io.File outputDirectory;
    private java.util.HashMap _$_findViewCache;
    
    public BaseCamera() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final com.futuretech.pdfreaderconverter.databinding.ActivityCameraScreenBinding getCameraBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.data.viewmodel.FileViewModel getFileViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.futuretech.pdfreaderconverter.data.viewmodel.ImageQueueViewModel getImageQueueViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.futuretech.pdfreaderconverter.model.ImageQueue getImageQueueObj() {
        return null;
    }
    
    public final void setImageQueueObj(@org.jetbrains.annotations.Nullable()
    com.futuretech.pdfreaderconverter.model.ImageQueue p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> getImageQueueArrayList() {
        return null;
    }
    
    protected final void setImageQueueArrayList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.futuretech.pdfreaderconverter.model.ImageQueue> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final android.net.Uri getUri() {
        return null;
    }
    
    protected final void setUri(@org.jetbrains.annotations.Nullable()
    android.net.Uri p0) {
    }
    
    protected final boolean getHasBatchMode() {
        return false;
    }
    
    protected final void setHasBatchMode(boolean p0) {
    }
    
    protected final boolean getHasGridMode() {
        return false;
    }
    
    protected final void setHasGridMode(boolean p0) {
    }
    
    protected final boolean getHasFlashMode() {
        return false;
    }
    
    protected final void setHasFlashMode(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.camera.core.Camera getCamera() {
        return null;
    }
    
    protected final void setCamera(@org.jetbrains.annotations.Nullable()
    androidx.camera.core.Camera p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.List<android.net.Uri> getUris() {
        return null;
    }
    
    protected final void setUris(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends android.net.Uri> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.camera.core.ImageAnalysis getImageAnalyzer() {
        return null;
    }
    
    protected final void setImageAnalyzer(@org.jetbrains.annotations.Nullable()
    androidx.camera.core.ImageAnalysis p0) {
    }
    
    protected final int getLensFacing() {
        return 0;
    }
    
    protected final void setLensFacing(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.camera.core.Preview.Builder getPreviewBuilder() {
        return null;
    }
    
    protected final void setPreviewBuilder(@org.jetbrains.annotations.Nullable()
    androidx.camera.core.Preview.Builder p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.camera.core.Preview getPreview() {
        return null;
    }
    
    protected final void setPreview(@org.jetbrains.annotations.Nullable()
    androidx.camera.core.Preview p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.camera.core.ImageCapture.Builder getImageCaptureBuilder() {
        return null;
    }
    
    protected final void setImageCaptureBuilder(@org.jetbrains.annotations.Nullable()
    androidx.camera.core.ImageCapture.Builder p0) {
    }
    
    protected final int getCaptureCounter() {
        return 0;
    }
    
    protected final void setCaptureCounter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getFilename() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.lang.String getPhotoExtension() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.util.concurrent.ExecutorService getCameraExecutor() {
        return null;
    }
    
    protected final void setCameraExecutor(@org.jetbrains.annotations.NotNull()
    java.util.concurrent.ExecutorService p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final androidx.camera.core.ImageCapture getImageCapture() {
        return null;
    }
    
    protected final void setImageCapture(@org.jetbrains.annotations.Nullable()
    androidx.camera.core.ImageCapture p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.io.File getOutputDirectory() {
        return null;
    }
    
    protected final void setOutputDirectory(@org.jetbrains.annotations.NotNull()
    java.io.File p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final java.io.File createFile(@org.jetbrains.annotations.NotNull()
    java.io.File baseFolder, @org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    java.lang.String extension) {
        return null;
    }
    
    protected final void setGalleryThumbnail(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    protected final int aspectRatio(int width, int height) {
        return 0;
    }
    
    protected final void hideBackArrowThumbnailWidget() {
    }
    
    protected final void showBackArrowThumbnailWidget() {
    }
    
    @android.annotation.SuppressLint(value = {"LogNotTimber"})
    protected final void enableFocusFeature() {
    }
    
    private final void afterMeasured(android.view.View $this$afterMeasured, kotlin.jvm.functions.Function0<kotlin.Unit> block) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    protected final void enableZoomFeature() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/futuretech/pdfreaderconverter/ui/camera/BaseCamera$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}