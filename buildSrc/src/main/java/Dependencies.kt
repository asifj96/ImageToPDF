object Versions {
    const val minSdk = 21
    const val compileSdk = 31
    const val targetSdk = 31
    const val versionCode = 2
    const val versionName = "1.1"
    const val coreKtx = "1.7.0"
    const val appCompat = "1.4.1"
    const val materialDesign = "1.5.0"
    const val constraintLayout = "2.1.3"
    const val junit = "4.13.2"
    const val junitTest = "1.1.3"
    const val espressoCore = "3.4.0"
    const val jvmTarget = "1.8"
    const val firebaseBom = "29.0.1"
    const val gradle = "7.0.3"
    const val gradlePlugin = "1.6.0"
    const val googleServices = "4.3.10"
    const val firebaseCrashlytics = "2.7.1"
    const val hilt = "2.41"
    const val multiDex = "2.0.1"
    const val dimension = "1.0.6"
    const val glide = "4.12.0"
    const val coroutine = "1.6.0"
    const val preferenceKts = "1.2.0"
    const val recyclerView = "1.2.1"
    const val lottieAnim = "4.1.0"
    const val adsLite = "20.5.0"
    const val shimmer = "0.5.0@aar"
    const val lifecycle = "2.4.1"
    const val lifecycleExtensions = "2.2.0"
    const val navigation = "2.4.1"
    const val navigationGradlePlugin = "2.5.0-alpha01"
    const val activityKtx = "1.4.0"
    const val fragmentKtx = "1.4.0"
    const val workMangerKtx = "2.7.1"
    const val cameraVersion = "1.1.0-beta02"
//    const val cameraVersion = "1.0.2"

    //    const val dataBindingCompiler = "3.5.0"
    const val dataBindingCompiler = "3.2.0-alpha04"
    const val gson = "2.8.8"
    const val easyPermission = "3.0.0"
    const val pdfViewer = "3.2.0-beta.1"

}

object Android {
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val junit = "junit:junit:${Versions.junit}"
    const val junitTest = "androidx.test.ext:junit:${Versions.junitTest}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val multiDex = "androidx.multidex:multidex:${Versions.multiDex}"
    const val sdp = "com.intuit.sdp:sdp-android:${Versions.dimension}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.dimension}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val lottieAnim = "com.airbnb.android:lottie:${Versions.lottieAnim}"
    const val adsLite = "com.google.android.gms:play-services-ads-lite:${Versions.adsLite}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    const val workMangerKtx = "androidx.work:work-runtime-ktx:${Versions.workMangerKtx}"
    const val dataBindingCompiler =
        "com.android.databinding:compiler:${Versions.dataBindingCompiler}"
}

object EasyPermission {
    const val easyPermission = "pub.devrel:easypermissions:${Versions.easyPermission}"
}


object Gson {

    const val gson = "com.google.code.gson:gson:${Versions.gson}"
}

object Navigation {
    const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val uiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
}

object Firebase {
    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBom}"
    const val firebaseCrashlytics = "com.google.firebase:firebase-crashlytics-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"
    const val firebaseConfig = "com.google.firebase:firebase-config-ktx"
    const val firebaseInstallations = "com.google.firebase:firebase-installations-ktx"
}

object Plugins {
    const val androidApplication = "com.android.application"

    //    const val kotlinAndroid = "org.jetbrains.kotlin.android"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinExtensions = "kotlin-android-extensions"
    const val googleServices = "com.google.gms.google-services"
    const val firebaseCrashlytics = "com.google.firebase.crashlytics"
    const val hilt = "dagger.hilt.android.plugin"
    const val navigationSafeArgs = "androidx.navigation.safeargs.kotlin"
}

object Classpath {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.gradlePlugin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    const val firebaseCrashlytics =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.firebaseCrashlytics}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
    const val navigationGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationGradlePlugin}"
}

object DaggerHilt {
    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
}

object Glide {
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
}

object Coroutine {
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
}

object Camera {
    const val cameraCore = "androidx.camera:camera-core:${Versions.cameraVersion}"
    const val cameraX = "androidx.camera:camera-camera2:${Versions.cameraVersion}"
    const val cameraLifecycle = "androidx.camera:camera-lifecycle:${Versions.cameraVersion}"
    const val cameraView = "androidx.camera:camera-view:${Versions.cameraVersion}"
}

object LifeCycle {
    const val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions =
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExtensions}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
}

object SharedPreference {
    const val preferenceKts = "androidx.preference:preference-ktx:${Versions.preferenceKts}"
}

object PDFViewer {

    const val pdfViewer = "com.github.barteksc:android-pdf-viewer:${Versions.pdfViewer}"
}