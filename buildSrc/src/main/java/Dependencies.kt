object Versions {

    const val kotlin = "1.5.0"

    //Androidx
    const val androidx = "1.5.0"
    const val appCompat = "1.3.0"
    const val constraintLayout = "2.0.4"

    //UI
    const val material = "1.3.0"

    //DI
    const val dagger = "2.36"

    // Logging
    const val timber = "4.7.1"

    // Network
    const val retrofit = "2.9.0"
    const val moshi = "1.12.0"
    const val okHttp = "4.9.0"
    const val networkResponseAdapter = "4.2.1"

    // Navigation
    const val navigation = "2.3.5"

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
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    //UI
    const val material = "com.google.android.material:material:${Versions.material}"

    // DI
    const val daggerHilt = "com.google.dagger:hilt-android:${Versions.dagger}"
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"

    // Navigation
    const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Logging
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    //Network
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshiAdapters = "com.squareup.moshi:moshi-adapters:${Versions.moshi}"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    const val networkResponseAdapter =
        "com.github.haroldadmin:NetworkResponseAdapter:${Versions.networkResponseAdapter}"

    //Testing
    const val junit = "junit:junit:${Versions.junit}"

    //Plugins
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.dagger}"
}

object Modules {
    const val network = ":network"
    const val navigation = ":navigation"

    object Features {
        const val login = ":features:login"
        const val profile = ":features:profile"
    }
}