object ConfigData {
    const val compileSdkVersion = 33
    const val minSdkVersion = 24
    const val targetSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val jvmTarget = "1.8"

}

object BuildPlugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinJetBrains = "org.jetbrains.kotlin.android"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
}


object Versions {

    //BuildPlugins
    val androidApplication = "7.4.1"
    val androidLibrary = "7.4.1"
    val kotlinJetBrains = "1.8.0"

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
}