object ConfigData {
    const val compileSdkVersion = 33
    const val minSdkVersion = 24
    const val targetSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "1.8"
}

object Modules {
    const val app = ":app"
    const val common = ":common"
    const val data = ":data"
    const val domain = ":domain"
    const val feature = ":feature"
    const val navigation = ":navigation"
}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinJetBrains = "org.jetbrains.kotlin.android"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val daggerHilt = "com.google.dagger.hilt.android"
    const val kapt = "kapt"
}


object Versions {

    //BuildPlugins
    const val androidApplication = "7.4.1"
    const val androidLibrary = "7.4.1"
    const val kotlinJetBrains = "1.8.0"
    const val hilt = "2.44"

    //Android Libraries
    const val core = "1.7.0"
    const val appCompat = "1.6.1"
    const val material = "1.8.0"
    const val constraintLayout = "2.1.4"
    const val legacy = "1.0.0"
    const val junit = "4.13.2"
    const val extJunit = "1.1.5"
    const val espressoCore = "3.5.1"
    const val navVersion = "2.5.3"
    const val paging = "3.1.1"
    const val glide = "4.15.1"
    const val retrofit = "2.9.0"
    const val retrofitCor = "0.9.2"
    const val gson = "2.10"
    const val okhttp = "3.6.0"
    const val okhttpInterceptor = "4.10.0"
    const val lifecycleExt = "2.2.0"
    const val lifecycle = "2.6.1"
    const val fragment = "1.5.6"
    const val activity = "1.7.0"
}

object AndroidLibraries {

    //androidx
    const val androidxCore = "androidx.core:core-ktx:${Versions.core}"
    const val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    //material
    const val material = "com.google.android.material:material:${Versions.material}"

    //constraintLayout
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"

    //test
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    //navigation
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"

    //hilt
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val daggerHiltCom = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //paging3
    const val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    //glide
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"

    // Retrofit
    const val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val retrofitCoroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCor}"

    // Gson
    const val gson =  "com.google.code.gson:gson:${Versions.gson}"

    //okhttp
    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}"

    // Lifecycle
    const val lifecycleExtensions =  "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExt}"
    const val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val activity = "androidx.activity:activity-ktx:${Versions.activity}"
}