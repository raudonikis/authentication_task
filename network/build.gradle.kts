plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(Dependencies.kotlin)
    implementation(Dependencies.retrofit)
    implementation(Dependencies.moshi)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.moshiAdapters)
    implementation(Dependencies.okHttpInterceptor)
    implementation(Dependencies.networkResponseAdapter)
}