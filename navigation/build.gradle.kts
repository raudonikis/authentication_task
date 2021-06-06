plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    //Modules
    implementation(project(Modules.common))
    //Navigation
    api(Dependencies.navigationFragment)
    api(Dependencies.navigationUi)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}