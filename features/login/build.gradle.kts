plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    //Modules
    implementation(project(Modules.navigation))
    implementation(project(Modules.common_ui))

    implementation(Dependencies.kotlin)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}