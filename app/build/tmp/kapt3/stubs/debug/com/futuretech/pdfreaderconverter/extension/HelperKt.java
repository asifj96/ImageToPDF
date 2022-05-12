package com.futuretech.pdfreaderconverter.extension;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Editable;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.dialog.ConfirmationDialog;
import com.futuretech.pdfreaderconverter.dialog.LoadingDialog;
import com.futuretech.pdfreaderconverter.model.RootItem;
import pub.devrel.easypermissions.EasyPermissions;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007\u001a\u001e\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u001a\u0006\u0010\r\u001a\u00020\u000e\u001a\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0012\u001a*\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00140%\u001a\n\u0010&\u001a\u00020\u000b*\u00020\u0016\u001a\u0012\u0010\'\u001a\u00020\u000b*\u00020\u00162\u0006\u0010(\u001a\u00020\u0001\u001a\u0014\u0010)\u001a\u0004\u0018\u00010\u001c*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0010\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+*\u00020\u0016\u001a\u0014\u0010-\u001a\u00020\u000b*\u00020\u00162\u0006\u0010.\u001a\u00020\u0001H\u0007\u001a\u0012\u0010/\u001a\u00020\u000b*\u00020\u00162\u0006\u00100\u001a\u00020\u000b\u001a\n\u00101\u001a\u00020\u000e*\u00020\u0016\u001a\n\u00102\u001a\u00020\u000e*\u00020\u0016\u001a\u0012\u00103\u001a\u00020\u0014*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0014\u00104\u001a\u0004\u0018\u00010\u001c*\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001c\u001a\n\u00105\u001a\u00020\u000e*\u00020\u0016\u001a\n\u00106\u001a\u00020\u0014*\u00020\u0016\u001a\u0014\u00107\u001a\u00020\u0014*\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u001a5\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2!\u0010=\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b>\u0012\b\b0\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u00140%\u001a\n\u0010@\u001a\u00020\u0014*\u00020\u0016\u001a\n\u0010A\u001a\u00020\u0014*\u00020\u0016\u001a\n\u0010B\u001a\u00020\u0014*\u00020\u0016\u001a\u001a\u0010C\u001a\u00020D*\u00020\u00162\u0006\u0010\"\u001a\u00020#2\u0006\u0010E\u001a\u00020\u000b\u001a\u0012\u0010F\u001a\u00020\u0014*\u00020\u00162\u0006\u0010G\u001a\u00020\u000b\u001a\n\u0010H\u001a\u00020I*\u00020\u000b\u001a$\u0010J\u001a\u00020\u0014*\u00020\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\n\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0012\"\u001a\u0010\u0000\u001a\u00020\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\u00a8\u0006M"}, d2 = {"mLastClickTime", "", "getMLastClickTime", "()J", "setMLastClickTime", "(J)V", "createFile", "Ljava/io/File;", "baseFolder", "createPdfFile", "format", "", "extension", "disableClick", "", "getCurrentTimeStamp", "hasSdkHigherThan", "sdk", "", "openMenuItems", "", "context", "Landroid/content/Context;", "view", "Landroid/view/View;", "listener", "Landroidx/appcompat/widget/PopupMenu$OnMenuItemClickListener;", "rotateBitmap", "Landroid/graphics/Bitmap;", "bitmap", "i", "showConfirmationDialog", "activity", "Landroid/app/Activity;", "parentFragmentManager", "Landroidx/fragment/app/FragmentManager;", "onDialogAction", "Lkotlin/Function1;", "getCurrentDate", "getDate", "time", "getMainFrameBitmap", "getRootItemArrayList", "Ljava/util/ArrayList;", "Lcom/futuretech/pdfreaderconverter/model/RootItem;", "getSize", "size", "getTitleCurrentDate", "name", "hasCameraPermission", "hasStoragePermission", "hideKeyboard", "imageBitmap", "isNetworkAvailable", "privacyPolicy", "rateUs", "registerObserver", "Landroid/database/ContentObserver;", "Landroid/content/ContentResolver;", "uri", "Landroid/net/Uri;", "observer", "Lkotlin/ParameterName;", "selfChange", "sendFeedbackEmail", "shareApp", "showKeyboard", "showLoadingDialog", "Lcom/futuretech/pdfreaderconverter/dialog/LoadingDialog;", "title", "showToast", "str", "toEditable", "Landroid/text/Editable;", "writeBitmap", "Landroid/graphics/Bitmap$CompressFormat;", "quality", "app_debug"})
public final class HelperKt {
    private static long mLastClickTime = 0L;
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String str) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.ArrayList<com.futuretech.pdfreaderconverter.model.RootItem> getRootItemArrayList(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getRootItemArrayList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentDate(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getCurrentDate) {
        return null;
    }
    
    public static final void shareApp(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$shareApp) {
    }
    
    public static final boolean hasSdkHigherThan(int sdk) {
        return false;
    }
    
    public static final void rateUs(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$rateUs, @org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.annotation.SuppressLint(value = {"DefaultLocale"})
    public static final java.lang.String getSize(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getSize, long size) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getDate(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getDate, long time) {
        return null;
    }
    
    public static final long getMLastClickTime() {
        return 0L;
    }
    
    public static final void setMLastClickTime(long p0) {
    }
    
    public static final boolean disableClick() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.text.Editable toEditable(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$toEditable) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getTitleCurrentDate(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getTitleCurrentDate, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.futuretech.pdfreaderconverter.dialog.LoadingDialog showLoadingDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showLoadingDialog, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager parentFragmentManager, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return null;
    }
    
    public static final void showConfirmationDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager parentFragmentManager, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.app.Activity, kotlin.Unit> onDialogAction) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.io.File createFile(@org.jetbrains.annotations.NotNull()
    java.io.File baseFolder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.io.File createPdfFile(@org.jetbrains.annotations.NotNull()
    java.io.File baseFolder, @org.jetbrains.annotations.NotNull()
    java.lang.String format, @org.jetbrains.annotations.NotNull()
    java.lang.String extension) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap getMainFrameBitmap(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getMainFrameBitmap, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap imageBitmap(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$imageBitmap, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final android.graphics.Bitmap rotateBitmap(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap, int i) {
        return null;
    }
    
    public static final void writeBitmap(@org.jetbrains.annotations.NotNull()
    java.io.File $this$writeBitmap, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap bitmap, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap.CompressFormat format, int quality) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getCurrentTimeStamp() {
        return null;
    }
    
    public static final void showKeyboard(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showKeyboard) {
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$hideKeyboard, @org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.database.ContentObserver registerObserver(@org.jetbrains.annotations.NotNull()
    android.content.ContentResolver $this$registerObserver, @org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> observer) {
        return null;
    }
    
    public static final void sendFeedbackEmail(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$sendFeedbackEmail) {
    }
    
    public static final void privacyPolicy(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$privacyPolicy) {
    }
    
    @android.annotation.SuppressLint(value = {"RestrictedApi"})
    public static final void openMenuItems(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener listener) {
    }
    
    public static final boolean hasCameraPermission(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$hasCameraPermission) {
        return false;
    }
    
    public static final boolean hasStoragePermission(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$hasStoragePermission) {
        return false;
    }
    
    public static final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$isNetworkAvailable) {
        return false;
    }
}