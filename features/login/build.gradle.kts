plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    buildFeatures.viewBinding = true
}

dependencies {
    //Modules
    implementation(project(Modules.navigation))
    implementation(project(Modules.common))
    implementation(project(Modules.common_ui))
    implementation(project(Modules.network))
    implementation(project(Modules.auth))
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
    //Testing
    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    testImplementation(Dependencies.coroutinesTest)
}