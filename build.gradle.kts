buildscript {
    dependencies {
        classpath(AndroidLibraries.navigationSafeArgs)
    }
}
plugins {
    id(BuildPlugins.androidApplication) version Versions.androidApplication apply false
    id(BuildPlugins.androidLibrary) version Versions.androidLibrary apply false
    id(BuildPlugins.kotlinJetBrains) version Versions.kotlinJetBrains apply false
    id(BuildPlugins.daggerHilt) version Versions.hilt apply false
}