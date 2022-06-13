package com.futuretech.pdfreaderconverter.ads;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.cardview.widget.CardView;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.futuretech.pdfreaderconverter.R;
import com.futuretech.pdfreaderconverter.utility.Logger;
import com.google.android.gms.ads.*;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;

@kotlin.Metadata(mv = {1, 6, 0}, k = 2, d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001aH\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\u001a4\u0010\u0014\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u00a8\u0006\u0015"}, d2 = {"populateNativeAdViewLarge", "", "nativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "adView", "Lcom/google/android/gms/ads/nativead/NativeAdView;", "loadNativeAd", "Landroid/app/Activity;", "adFrame", "Landroid/widget/FrameLayout;", "layoutRes", "", "nativeId", "", "shimmerLayout", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "container", "Landroidx/cardview/widget/CardView;", "onAdLoaded", "Lkotlin/Function1;", "loadPreloadedAd", "app_release"})
public final class AdsFunctionKt {
    
    public static final void loadPreloadedAd(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$loadPreloadedAd, @org.jetbrains.annotations.NotNull()
    android.widget.FrameLayout adFrame, @androidx.annotation.LayoutRes()
    int layoutRes, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.nativead.NativeAd nativeAd, @org.jetbrains.annotations.NotNull()
    com.facebook.shimmer.ShimmerFrameLayout shimmerLayout, @org.jetbrains.annotations.NotNull()
    androidx.cardview.widget.CardView container) {
    }
    
    public static final void loadNativeAd(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$loadNativeAd, @org.jetbrains.annotations.NotNull()
    android.widget.FrameLayout adFrame, @androidx.annotation.LayoutRes()
    int layoutRes, @org.jetbrains.annotations.NotNull()
    java.lang.String nativeId, @org.jetbrains.annotations.NotNull()
    com.facebook.shimmer.ShimmerFrameLayout shimmerLayout, @org.jetbrains.annotations.NotNull()
    androidx.cardview.widget.CardView container, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.google.android.gms.ads.nativead.NativeAd, kotlin.Unit> onAdLoaded) {
    }
    
    public static final void populateNativeAdViewLarge(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.nativead.NativeAd nativeAd, @org.jetbrains.annotations.NotNull()
    com.google.android.gms.ads.nativead.NativeAdView adView) {
    }
}