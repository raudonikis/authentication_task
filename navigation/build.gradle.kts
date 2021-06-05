plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    //Kotlin
    implementation(Dependencies.kotlinCoroutines)
    //Navigation
    api(Dependencies.navigationFragment)
    api(Dependencies.navigationUi)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}