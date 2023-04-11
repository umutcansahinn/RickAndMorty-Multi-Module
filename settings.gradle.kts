pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "RickAndMortyMultiModuleKotlinDsl"
include(":app")
include(":common")
include(":data")
include(":domain")
include(":feature")
include(":navigation")
