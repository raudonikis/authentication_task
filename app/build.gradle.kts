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
    hilt {
        enableExperimentalClasspathAggregation = true
    }
    lintOptions {
        isCheckReleaseBuilds = false
    }
}

dependencies {
    //Modules
    implementation(project(Modules.navigation))
    implementation(project(Modules.common))
    implementation(project(Modules.common_ui))
    implementation(project(Modules.auth))
    implementation(project(Modules.Features.login))
    implementation(project(Modules.Features.profile))
    //Testing
    testImplementation(Dependencies.junit)
    //DI
    implementation(Dependencies.daggerHilt)
    kapt(Dependencies.daggerCompiler)
}