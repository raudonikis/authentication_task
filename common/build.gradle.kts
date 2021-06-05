plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    //Kotlin
    api(Dependencies.kotlin)
    api(Dependencies.kotlinCoroutines)
    //Androidx
    api(Dependencies.androidx)
    api(Dependencies.appCompat)
    api(Dependencies.preferences)
    //Logging
    api(Dependencies.timber)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}