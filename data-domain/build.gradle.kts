plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    //Modules
    implementation(project(Modules.navigation))
    implementation(project(Modules.common))
    //JWT token
    implementation(Dependencies.jwtToken)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}