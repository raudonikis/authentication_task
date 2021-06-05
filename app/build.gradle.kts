plugins {
    id("com.android.application")
    kotlin("android")
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
    implementation(Dependencies.androidx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    testImplementation(Dependencies.junit)
}