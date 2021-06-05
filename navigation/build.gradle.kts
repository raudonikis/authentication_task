plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    //Navigation
    api(Dependencies.navigationFragment)
    api(Dependencies.navigationUi)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}