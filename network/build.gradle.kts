plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    //Modules
    implementation(project(Modules.common))
    //Network
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.moshiAdapters)
    implementation(Dependencies.okHttpInterceptor)
    api(Dependencies.networkResponseAdapter)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}