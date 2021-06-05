plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(project(Modules.navigation))
    implementation(Dependencies.kotlin)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}