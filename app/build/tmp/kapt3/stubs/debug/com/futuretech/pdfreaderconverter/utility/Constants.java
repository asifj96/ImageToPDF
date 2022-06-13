package com.futuretech.pdfreaderconverter.utility;

import com.google.android.gms.ads.nativead.NativeAd;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0012X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0019\u00103\u001a\b\u0012\u0004\u0012\u00020\u001204\u00a2\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106R\u001c\u00108\u001a\u0004\u0018\u000109X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006>"}, d2 = {"Lcom/futuretech/pdfreaderconverter/utility/Constants;", "", "()V", "ACTION_CLICK", "", "ACTION_CROP", "ACTION_DELETE", "ACTION_FILTERS", "ACTION_LONG_CLICK", "ACTION_OPEN", "ACTION_RENAME", "ACTION_RETAKE", "ACTION_SAVE_GALLERY", "ACTION_SEARCH", "ACTION_SHARE", "ACTION_TAP", "CAMERA_RESULT", "COLOR_BLACK", "", "COLOR_BLUE", "COLOR_BROWN", "COLOR_GREEN", "COLOR_PURPLE", "COLOR_WHITE", "COLOR_YELLOW", "CROP", "CROP_IMAGE_RESULT", "DRAFT_OPERATION_RESULT", "DRAFT_SELECTION_RESULT", "FILENAME", "FILE_MODEL_OBJ", "FILE_PATH", "FILE_URI", "FILTERS", "FILTER_IMAGE_RESULT", "GALLERY_IMAGE", "GALLERY_PICKER_RESULT", "IMAGE_POS", "IMAGE_QUEUE_LIST", "IMAGE_URI_PATH", "LONG_CLICK", "PDF", "PDF_FILE_ARRAY_LIST", "PDF_FILE_FRAGMENT", "PDF_FILE_OBJECT", "PHOTO_EXTENSION", "RC_CAMERA_PERM", "RC_GALLERY_PERM", "REQUEST_WRITE_PERMISSION", "RETAKE_IMAGE_RESULT", "SIGNATURE_RESULT", "STORAGE_PERMISSION", "", "getSTORAGE_PERMISSION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "mainFullNativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "getMainFullNativeAd", "()Lcom/google/android/gms/ads/nativead/NativeAd;", "setMainFullNativeAd", "(Lcom/google/android/gms/ads/nativead/NativeAd;)V", "app_debug"})
public final class Constants {
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.utility.Constants INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String[] STORAGE_PERMISSION = {"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"};
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILENAME = "yyyy-MM-dd-HH-mm-ss-SSS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PHOTO_EXTENSION = ".png";
    public static final int REQUEST_WRITE_PERMISSION = 100;
    public static final int RC_CAMERA_PERM = 124;
    public static final int RC_GALLERY_PERM = 125;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_POS = "IMAGE_POS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CROP = "CROP";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PDF = "PDF";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILTERS = "FILTERS";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_URI_PATH = "IMAGE_URI_PATH";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String IMAGE_QUEUE_LIST = "IMAGE_QUEUE_LIST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PDF_FILE_OBJECT = "PDF_FILE_OBJECT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PDF_FILE_ARRAY_LIST = "PDF_FILE_ARRAY_LIST";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILE_URI = "FILE_URI";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String PDF_FILE_FRAGMENT = "PDF_FILE_FRAGMENT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILE_MODEL_OBJ = "FILE_MODEL_OBJ";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILE_PATH = "FILE_PATH";
    public static final int ACTION_OPEN = 0;
    public static final int ACTION_SHARE = 1;
    public static final int ACTION_RENAME = 2;
    public static final int ACTION_DELETE = 3;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String GALLERY_IMAGE = "GALLERY_IMAGE";
    public static final int ACTION_SAVE_GALLERY = 4;
    public static final int ACTION_TAP = 7;
    public static final int LONG_CLICK = 8;
    public static final int ACTION_SEARCH = 9;
    public static final int ACTION_CLICK = 10;
    public static final int ACTION_LONG_CLICK = 11;
    public static final int ACTION_CROP = 100;
    public static final int ACTION_FILTERS = 101;
    public static final int ACTION_RETAKE = 102;
    public static final int DRAFT_OPERATION_RESULT = 200;
    public static final int CAMERA_RESULT = 202;
    public static final int DRAFT_SELECTION_RESULT = 201;
    public static final int GALLERY_PICKER_RESULT = 203;
    public static final int FILTER_IMAGE_RESULT = 204;
    public static final int SIGNATURE_RESULT = 206;
    public static final int CROP_IMAGE_RESULT = 205;
    public static final int RETAKE_IMAGE_RESULT = 206;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_BLACK = "COLOR_BLACK";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_WHITE = "COLOR_WHITE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_YELLOW = "COLOR_YELLOW";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_BROWN = "COLOR_BROWN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_BLUE = "COLOR_BLUE";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_GREEN = "COLOR_GREEN";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLOR_PURPLE = "COLOR_PURPLE";
    @org.jetbrains.annotations.Nullable()
    private static com.google.android.gms.ads.nativead.NativeAd mainFullNativeAd;
    
    private Constants() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String[] getSTORAGE_PERMISSION() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.google.android.gms.ads.nativead.NativeAd getMainFullNativeAd() {
        return null;
    }
    
    public final void setMainFullNativeAd(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.ads.nativead.NativeAd p0) {
    }
}