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
    val androidApplication = "7.4.1"
    val androidLibrary = "7.4.1"
    val kotlinJetBrains = "1.8.0"
    val hilt = "2.44"

    //Android Libraries
    val core = "1.7.0"
    val appCompat = "1.6.1"
    val material = "1.8.0"
    val constraintLayout = "2.1.4"
    val legacy = "1.0.0"
    val junit = "4.13.2"
    val extJunit = "1.1.5"
    val espressoCore = "3.5.1"
    val navVersion = "2.5.3"
    val paging = "3.1.1"
    val glide = "4.15.1"
    val retrofit = "2.9.0"
    val retrofitCor = "0.9.2"
    val gson = "2.10"
    val okhttp = "3.6.0"
    val okhttpInterceptor = "4.10.0"
    val lifecycleExt = "2.2.0"
    val lifecycle = "2.6.1"
    val fragment = "1.5.6"
    val activity = "1.7.0"
}

object AndroidLibraries {

    //androidx
    val androidxCore = "androidx.core:core-ktx:${Versions.core}"
    val androidxAppCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"

    //material
    val material = "com.google.android.material:material:${Versions.material}"

    //constraintLayout
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"

    //test
    val junit = "junit:junit:${Versions.junit}"
    val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"

    //navigation
    val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navVersion}"

    //hilt
    val daggerHilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    val daggerHiltCom = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"

    //paging3
    val paging = "androidx.paging:paging-runtime:${Versions.paging}"

    //glide
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
   // val glideComp = "com.github.bumptech.glide:compiler:${Versions.glide}"

    // Retrofit
    val retrofit =  "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val retrofitCoroutines = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCor}"

    // Gson
    val gson =  "com.google.code.gson:gson:${Versions.gson}"

    //okhttp
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}"

    // Lifecycle
    val lifecycleExtensions =  "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleExt}"
    val lifecycleRunTime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val activity = "androidx.activity:activity-ktx:${Versions.activity}"
}