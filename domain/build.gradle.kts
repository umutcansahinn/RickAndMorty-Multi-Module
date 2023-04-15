plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinJetBrains)
    id(BuildPlugins.daggerHilt)
    kotlin(BuildPlugins.kapt)
}

android {
    namespace = "com.umutcansahin.domain"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {

    implementation(project(Modules.common))

    implementation(AndroidLibraries.androidxCore)
    implementation(AndroidLibraries.androidxAppCompat)
    implementation(AndroidLibraries.material)
    testImplementation(AndroidLibraries.junit)
    androidTestImplementation(AndroidLibraries.extJunit)
    androidTestImplementation(AndroidLibraries.espressoCore)

    implementation(AndroidLibraries.daggerHilt)
    kapt(AndroidLibraries.daggerHiltCom)
    implementation(AndroidLibraries.paging)
}