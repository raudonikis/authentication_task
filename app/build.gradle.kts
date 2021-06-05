plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    kotlin("android")
    kotlin("kapt")
}

android {
    defaultConfig {
        applicationId = "com.raudonikis.authentication_task"
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(Dependencies.kotlin)
    //Androidx
    implementation(Dependencies.androidx)
    implementation(Dependencies.appCompat)
    //UI
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    //Logging
    implementation(Dependencies.timber)
    //Testing
    testImplementation(Dependencies.junit)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}