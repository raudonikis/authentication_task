plugins {
    id("com.android.library")
    kotlin("android")
}

dependencies {
    //Modules
    implementation(project(Modules.common))
    implementation(project(Modules.network))
}