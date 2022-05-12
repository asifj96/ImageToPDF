package com.futuretech.pdfreaderconverter.ads

import android.app.Activity
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.cardview.widget.CardView
import com.facebook.shimmer.ShimmerFrameLayout
import com.futuretech.pdfreaderconverter.R
import com.futuretech.pdfreaderconverter.utility.Logger
import com.google.android.gms.ads.*
import com.google.android.gms.ads.nativead.NativeAd
import com.google.android.gms.ads.nativead.NativeAdOptions
import com.google.android.gms.ads.nativead.NativeAdView

fun Activity.loadPreloadedAd(
    adFrame: FrameLayout,
    @LayoutRes layoutRes: Int,
    nativeAd: NativeAd,
    shimmerLayout: ShimmerFrameLayout,
    container: CardView,
) {
    container.visibility = View.VISIBLE
    shimmerLayout.visibility = View.VISIBLE
    shimmerLayout.animate()
    val adView = layoutInflater
        .inflate(layoutRes, null, false) as NativeAdView
    populateNativeAdViewLarge(nativeAd, adView)

    shimmerLayout.visibility = View.GONE
    container.visibility = View.VISIBLE
    adFrame.visibility = View.VISIBLE
    adFrame.removeAllViews()
    adFrame.addView(adView)

}

/*fun Activity.loadNativeBannerAd(
    adFrame: FrameLayout,
    @LayoutRes layoutRes: Int,
    adType: AdType,
    nativeId: String,
    shimmerLayout: ShimmerFrameLayout,
    container: CardView,
    onAdLoaded: (NativeAd) -> Unit,
) {
    container.visibility = View.VISIBLE
    shimmerLayout.visibility = View.VISIBLE
    shimmerLayout.animate()
    val builder = AdLoader.Builder(this, nativeId)
    builder.forNativeAd { nativeAd ->

        if (isDestroyed || isFinishing || isChangingConfigurations) {
            nativeAd.destroy()
            return@forNativeAd
        }

        onAdLoaded.invoke(nativeAd)

        val adView = layoutInflater
            .inflate(layoutRes, null, false) as NativeAdView
        if (adType == AdType.SMALL) {
            populateNativeAdViewSmall(nativeAd, adView)
        } else if (adType == AdType.LARGE) {
            populateNativeAdViewLarge(nativeAd, adView)
        }
        shimmerLayout.visibility = View.GONE
        container.visibility = View.VISIBLE
        adFrame.visibility = View.VISIBLE
        adFrame.removeAllViews()
        adFrame.addView(adView)
    }

    val videoOptions = VideoOptions.Builder()
        .setStartMuted(true)
        .build()

    val adOptions = NativeAdOptions.Builder()
        .setVideoOptions(videoOptions)
        .build()

    builder.withNativeAdOptions(adOptions)
        .withNativeAdOptions(
            NativeAdOptions.Builder()
                .setRequestCustomMuteThisAd(true)
                .build()
        )

    val adLoader = builder.withAdListener(object : AdListener() {
        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            val error =
                "${loadAdError.domain}, code: ${loadAdError.code}, message: ${loadAdError.message}"
            Logger.debug("Native", "Failed to load native ad with error $error\"")
            container.visibility = View.GONE
        }
    }).build()
    adLoader.loadAd(AdRequest.Builder().build())
}*/

fun Activity.loadNativeAd(
    adFrame: FrameLayout,
    @LayoutRes layoutRes: Int,
    nativeId: String,
    shimmerLayout: ShimmerFrameLayout,
    container: CardView,
    onAdLoaded: (NativeAd) -> Unit,
) {
    Logger.debug("AD_STATUS::=>", "loading")
    shimmerLayout.animate()
    val builder = AdLoader.Builder(this, nativeId)
    builder.forNativeAd { nativeAd ->

        val activityDestroyed: Boolean = isDestroyed
        if (activityDestroyed || isFinishing || isChangingConfigurations) {
            nativeAd.destroy()
            Logger.debug("AD_STATUS::=>", "loading")
            return@forNativeAd

        }
        onAdLoaded.invoke(nativeAd)
        val adView = layoutInflater
            .inflate(layoutRes, null, false) as NativeAdView
        populateNativeAdViewLarge(nativeAd, adView)
        shimmerLayout.visibility = View.GONE
        container.visibility = View.VISIBLE
        adFrame.visibility = View.VISIBLE
        adFrame.removeAllViews()
        adFrame.addView(adView)
    }

    val videoOptions = VideoOptions.Builder()
        .setStartMuted(true)
        .build()

    val adOptions = NativeAdOptions.Builder()
        .setVideoOptions(videoOptions)
        .build()

    builder.withNativeAdOptions(adOptions)
        .withNativeAdOptions(
            NativeAdOptions.Builder()
                .setRequestCustomMuteThisAd(true)
                .build()
        )

    val adLoader = builder.withAdListener(object : AdListener() {
        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            val error =
                "${loadAdError.domain}, code: ${loadAdError.code}, message: ${loadAdError.message}"
            Logger.debug("Native", "Failed to load native ad with error $error\"")
            container.visibility = View.GONE
        }
    }).build()
    adLoader.loadAd(AdRequest.Builder().build())
}

fun populateNativeAdViewLarge(nativeAd: NativeAd, adView: NativeAdView) {
    try {// Set the media view.
        adView.mediaView = adView.findViewById(R.id.ad_media)

        // Set other ad assets.
        adView.headlineView = adView.findViewById(R.id.ad_headline)
        adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)
        adView.iconView = adView.findViewById(R.id.ad_app_icon)
//        adView.starRatingView = adView.findViewById(R.id.ad_stars)
//        adView.advertiserView = adView.findViewById(R.id.ad_advertiser)

        (adView.headlineView as TextView).text = nativeAd.headline
        (adView.headlineView as TextView).isSelected = true
        if (adView.mediaView != null) {
            adView.mediaView?.setMediaContent(nativeAd.mediaContent!!)
            adView.mediaView?.setImageScaleType(ImageView.ScaleType.FIT_XY)
        }

        if (nativeAd.callToAction.isNullOrEmpty()) {
            adView.callToActionView?.visibility = View.INVISIBLE
        } else {
            adView.callToActionView?.visibility = View.VISIBLE
            (adView.callToActionView as TextView).text = nativeAd.callToAction
        }

        if (nativeAd.icon == null) {
            adView.iconView?.visibility = View.GONE
        } else {
            (adView.iconView as ImageView).setImageDrawable(
                nativeAd.icon?.drawable
            )
            adView.iconView?.visibility = View.VISIBLE
        }

        adView.setNativeAd(nativeAd)

        val vc = nativeAd.mediaContent?.videoController

        if (vc?.hasVideoContent() == true) {
            vc.videoLifecycleCallbacks = object : VideoController.VideoLifecycleCallbacks() {
                override fun onVideoEnd() {
                    Logger.debug("tagFunction", "video is end")

                    super.onVideoEnd()
                }
            }
        } else {
            Logger.debug("tagFunction", "this add has no video")
        }
    } catch (e: Exception) {
        Logger.debug("tagFunction E", e.toString())
        e.printStackTrace()
    }
}

/*
fun Activity.loadADsWithoutShimmerEffect(
    nativeId: String, listener: (NativeAd) -> Unit,
) {
    val builder = AdLoader.Builder(this, nativeId)
    builder.forNativeAd { nativeAd ->
        // OnUnifiedNativeAdLoadedListener implementation.
        // If this callback occurs after the activity is destroyed, you must call
        // destroy and return or you may get a memory leak.
        if (isDestroyed || isFinishing || isChangingConfigurations) {
            nativeAd.destroy()
            return@forNativeAd
        }
        listener.invoke(nativeAd)
    }

    val adOptions = NativeAdOptions.Builder()
        .setVideoOptions(VideoOptions.Builder().setStartMuted(true).build())
        .build()

    builder.withNativeAdOptions(adOptions)

    val adLoader = builder.withAdListener(object : AdListener() {
        override fun onAdFailedToLoad(loadAdError: LoadAdError) {
            val error =
                "${loadAdError.domain}, code: ${loadAdError.code}, message: ${loadAdError.message}"
            Logger.debug("Native", "Failed to load native ad with error $error\"")
        }
    }).build()
    adLoader.loadAd(AdRequest.Builder().build())
}
*/


/*fun Context.populateNativeRecyclerAd(
    nativeAd: NativeAd,
    @LayoutRes layoutRes: Int,
    frameLayout: FrameLayout,
) {

    val adView = LayoutInflater.from(this)
        .inflate(layoutRes, null, false) as NativeAdView

    frameLayout.removeAllViews()
    frameLayout.addView(adView)

    adView.mediaView = adView.findViewById(R.id.ad_media)
    adView.headlineView = adView.findViewById(R.id.ad_headline)
    adView.iconView = adView.findViewById(R.id.ad_app_icon)
    adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)

    (adView.headlineView as TextView).text = nativeAd.headline

    nativeAd.mediaContent?.let {
        adView.mediaView?.setMediaContent(it)
    }

    nativeAd.icon?.let {
        adView.iconView?.visibility = View.VISIBLE
        (adView.iconView as ImageView).setImageDrawable(it.drawable)
    } ?: run {
        adView.iconView?.visibility = View.INVISIBLE
    }

    if (adView.mediaView != null) {
        adView.mediaView?.setMediaContent(nativeAd.mediaContent!!)
        adView.mediaView?.setImageScaleType(ImageView.ScaleType.FIT_XY)
    }

    nativeAd.callToAction?.let { callToAction ->
        adView.callToActionView?.visibility = View.VISIBLE
        (adView.callToActionView as TextView).text = callToAction
    } ?: run {
        adView.callToActionView?.visibility = View.INVISIBLE
    }

    adView.setNativeAd(nativeAd)

    val vc = nativeAd.mediaContent?.videoController

    if (vc?.hasVideoContent() == true) {
        vc.videoLifecycleCallbacks = object : VideoController.VideoLifecycleCallbacks() {
            override fun onVideoEnd() {
                Log.e("tagFunction", "video is end")

                super.onVideoEnd()
            }
        }
    } else {
        Log.e("tagFunction", "this add has no video")
    }

}

fun populateNativeAdViewSmall(
    nativeAd: NativeAd,
    adView: NativeAdView,
) {

    adView.headlineView = adView.findViewById(R.id.ad_headline_banner)
    adView.callToActionView =
        adView.findViewById(R.id.ad_call_to_action_banner)
    adView.iconView = adView.findViewById(R.id.ad_app_icon_banner)
    adView.bodyView = adView.findViewById(R.id.ad_body)

    (adView.headlineView as TextView).text = nativeAd.headline
    (adView.headlineView as TextView).isSelected = true
    Logger.debug("Headline::=>", nativeAd.headline)

    nativeAd.mediaContent?.let {
        adView.mediaView?.setMediaContent(it)
    }
    nativeAd.callToAction?.let { callToAction ->
        adView.callToActionView?.visibility = View.VISIBLE
        (adView.callToActionView as TextView).text = callToAction
    } ?: run {
        adView.callToActionView?.visibility = View.INVISIBLE
    }

    nativeAd.icon?.let {
        adView.iconView?.visibility = View.VISIBLE
        (adView.iconView as ImageView).setImageDrawable(it.drawable)
    } ?: run {
        adView.iconView?.visibility = View.INVISIBLE
    }

    if (nativeAd.body.isNullOrEmpty()) {
        adView.bodyView?.visibility = View.INVISIBLE
    } else {
        adView.bodyView?.visibility = View.VISIBLE
        (adView.bodyView as TextView).text = nativeAd.body
    }

    *//*  if (nativeAd.starRating == null) {
          adView.starRatingView?.visibility = View.INVISIBLE
      } else {
          (adView.starRatingView as RatingBar).rating = nativeAd.starRating!!.toFloat()
          adView.starRatingView?.visibility = View.VISIBLE
      }*//*


*//*    nativeAd.advertiser?.let { advertiser ->
        adView.advertiserView?.visibility = View.GONE
        (adView.advertiserView as TextView).text = advertiser
    } ?: run {
        adView.advertiserView?.visibility = View.GONE
    }*//*

    adView.setNativeAd(nativeAd)
}*/

/*fun Activity.loadPreloadedNativeBannerAd(
    adFrame: FrameLayout,
    @LayoutRes layoutRes: Int,
    nativeAd: NativeAd,
    shimmerLayout: ShimmerFrameLayout,
    container: MaterialCardView,
) {
    container.visibility = View.VISIBLE
    shimmerLayout.visibility = View.VISIBLE
    shimmerLayout.animate()
    val adView = layoutInflater
        .inflate(layoutRes, null, false) as NativeAdView

    populateNativeBannerAdView(nativeAd, adView)
    shimmerLayout.visibility = View.GONE
    container.visibility = View.VISIBLE
    adFrame.visibility = View.VISIBLE
    adFrame.removeAllViews()
    adFrame.addView(adView)
}*/

/*fun populateNativeBannerAdView(
    nativeAd: NativeAd,
    adView: NativeAdView,
) {
    // Set other ad assets.
    adView.headlineView = adView.findViewById(R.id.ad_headline)
//    adView.bodyView = adView.findViewById(R.id.ad_description)
    adView.callToActionView = adView.findViewById(R.id.ad_call_to_action)
    adView.iconView = adView.findViewById(R.id.ad_app_icon)
    // The headline and media content are guaranteed to be in every UnifiedNativeAd.
    (adView.headlineView as TextView).text = nativeAd.headline
    if (nativeAd.icon == null) {
        adView.iconView?.visibility = View.GONE
    } else {
        (adView.iconView as ImageView).setImageDrawable(

            nativeAd.icon?.drawable
        )
        adView.iconView?.visibility = View.VISIBLE
    }
    if (nativeAd.callToAction == null) {
        adView.callToActionView?.visibility = View.INVISIBLE
    } else {
        adView.callToActionView?.visibility = View.VISIBLE
        (adView.callToActionView as TextView).text = nativeAd.callToAction

    }

    adView.setNativeAd(nativeAd)

}*/
