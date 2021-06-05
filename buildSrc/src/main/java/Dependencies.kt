object Versions {

    const val kotlin = "1.5.0"

    //Androidx
    const val androidx = "1.5.0"
    const val appCompat = "1.3.0"
    const val constraintLayout = "2.0.4"

    //UI
    const val material = "1.3.0"

    //Testing
    const val junit = "4.13.2"

    //Sdk
    const val buildTools = "30.0.3"
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
}

object Dependencies {

    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"

    //Androidx
    const val androidx = "androidx.core:core-ktx:${Versions.androidx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //UI
    const val material = "com.google.android.material:material:${Versions.material}"

    //Testing
    const val junit = "junit:junit:${Versions.junit}"

    //Plugins
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}