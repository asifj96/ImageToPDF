plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinExtensions)
    id(Plugins.googleServices)
    id(Plugins.firebaseCrashlytics)
//    id(Plugins.hilt)
    id(Plugins.navigationSafeArgs)
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        applicationId = "com.futuretech.pdfreaderconverter" // debug
//        applicationId = "com.futuretech.imagetopdf"  // release
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = Versions.versionCode
        versionName = Versions.versionName
        vectorDrawables.useSupportLibrary = true
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
            resValue("string", "appID", "ca-app-pub-5477431624667427~2376739917")
            resValue("string", "main_native", "ca-app-pub-5477431624667427/4438676912")
        }
        getByName("debug") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
            resValue("string", "appID", "ca-app-pub-3940256099942544~3347511713")
            resValue("string", "main_native", "ca-app-pub-3940256099942544/2247696110")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = Versions.jvmTarget
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Android
    implementation(Android.coreKtx)
    implementation(Android.appCompat)
    implementation(Android.materialDesign)
    implementation(Android.constraintLayout)
    implementation(Android.multiDex)
    implementation(Android.sdp)
    implementation(Android.ssp)
    implementation(Android.recyclerView)
    implementation(Android.lottieAnim)
    implementation(Android.fragmentKtx)
    implementation(Android.activityKtx)
    implementation(Android.workMangerKtx)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.appcompat:appcompat:1.4.1")
    implementation("com.google.android.material:material:1.5.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    kapt(Android.dataBindingCompiler)
    testImplementation(Android.junit)
    androidTestImplementation(Android.junitTest)
    androidTestImplementation(Android.espressoCore)
    api(Android.adsLite)
    implementation(Android.shimmer)

    implementation(Gson.gson)
    // Firebase
    implementation(platform(Firebase.firebaseBom))
    implementation(Firebase.firebaseCrashlytics)
    implementation(Firebase.firebaseAnalytics)
    implementation(Firebase.firebaseConfig)
    implementation(Firebase.firebaseInstallations)

    // DaggerHilt
//    implementation(DaggerHilt.hiltAndroid)
//    kapt(DaggerHilt.hiltCompiler)

    // Glide
    implementation(Glide.glide)
    annotationProcessor(Glide.glideCompiler)

    // Coroutine
    implementation(Coroutine.core)
    implementation(Coroutine.android)

    // SharedPreference
    implementation(SharedPreference.preferenceKts)

    // LifeCycle
    implementation(LifeCycle.viewmodelKtx)
    implementation(LifeCycle.livedataKtx)
    implementation(LifeCycle.lifecycleExtensions)
    implementation(LifeCycle.runtimeKtx)

    // Navigation
    implementation(Navigation.fragmentKtx)
    implementation(Navigation.uiKtx)

    // EasyPermission
    implementation(EasyPermission.easyPermission)

    // Camera
    implementation(Camera.cameraCore)
    implementation(Camera.cameraLifecycle)
    implementation(Camera.cameraX)
    implementation(Camera.cameraView)
    implementation("androidx.room:room-runtime:2.4.0")
    kapt("androidx.room:room-compiler:2.4.0")
    implementation("androidx.room:room-ktx:2.4.0")
    implementation(PDFViewer.pdfViewer)
    // Spin kit
    implementation("com.github.ybq:Android-SpinKit:1.4.0")

    // Cropping
    implementation ("com.theartofdev.edmodo:android-image-cropper:2.8.0")
    // Itext5
    implementation ("com.itextpdf:itextg:5.5.10")



}
kapt {
    correctErrorTypes = true
}