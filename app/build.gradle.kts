plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinJetBrains)
    id(BuildPlugins.safeArgs)
}

android {
    namespace = "com.umutcansahin.rickandmortymultimodulekotlindsl"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "com.umutcansahin.rickandmortymultimodulekotlindsl"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTarget
    }

    sourceSets {
        getByName("debug").res.srcDirs(
            "$rootDir/navigation/src/main/sharedRes"
        )
    }
}

dependencies {

    implementation(AndroidLibraries.androidxCore)
    implementation(AndroidLibraries.androidxAppCompat)
    implementation(AndroidLibraries.material)
    implementation(AndroidLibraries.constraintLayout)
    testImplementation(AndroidLibraries.junit)
    androidTestImplementation(AndroidLibraries.extJunit)
    androidTestImplementation(AndroidLibraries.espressoCore)

    implementation(AndroidLibraries.navigationFragment)
    implementation(AndroidLibraries.navigationUi)

}