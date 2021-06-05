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
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    //Modules
    implementation(project(Modules.navigation))
    implementation(project(Modules.common_ui))
    implementation(project(Modules.Features.login))
    implementation(project(Modules.Features.profile))

    implementation(Dependencies.kotlin)
    //Androidx
    implementation(Dependencies.androidx)
    implementation(Dependencies.appCompat)
    //Logging
    implementation(Dependencies.timber)
    //Testing
    testImplementation(Dependencies.junit)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}