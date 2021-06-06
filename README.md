# Authentication_task
![Min API](https://img.shields.io/badge/API-21%2B-orange.svg?style=flat)
[![Platform](https://img.shields.io/badge/platform-Android-green.svg)](http://developer.android.com/index.html)

An application done for a job interview with authentication.
* User can enter credentials and login;
* User is navigated to his profile upon successful authorization;
* In the profile screen, user can see his profile data;
* User can logout from the application;
* If the user is logged in, user is redirected to the profile upon opening the application.

### Screenshots

<p>
<img src="/pictures/login_screen.png" width="49%"/>
<img src="/pictures/profile_screen.png" width="49%"/>
</p>

## Tech stack

- [Kotlin](https://kotlinlang.org/) - official programming language for Android.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) and [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html#asynchronous-flow) - official Kotlin's tooling for performing asynchronous work.
- [MVVM Architecture](https://developer.android.com/jetpack/guide) - Official recommended architecture for building robust, production-quality apps.
- [Android Jetpack](https://developer.android.com/jetpack) - a suite of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices.
  - [Navigation](https://developer.android.com/guide/navigation) - framework for navigating between screens within an Android application.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way.
  - [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection library for Android.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - a feature that allows you to more easily write code that interacts with views.
- [Glide](https://github.com/bumptech/glide) - a fast and efficient open source media management and image loading framework for Android.
- [Retrofit](https://github.com/square/retrofit) - a library for building REST API clients.
- [Moshi](https://github.com/square/moshi) - a modern JSON library for Android and Java. It makes it easy to parse JSON into Java objects.
- [Timber](https://github.com/JakeWharton/timber) - a logger with a small, extensible API which provides utility on top of Android's normal Log class.
- [Gradle's Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) - Gradle’s Kotlin DSL is an alternative syntax to the Groovy DSL with an enhanced editing experience.
- [buildSrc](https://docs.gradle.org/current/userguide/organizing_gradle_projects.html#sec:build_sources) - a special module within the project to manage dependencies.

For more information about used dependencies, see [this](buildSrc/src/main/java/Dependencies.kt) file.

## Project structure

- app - main app module
- auth - authentication data
- buildSrc - special module for managing dependencies
- common - common logic between all or most modules
- common-ui - common UI logic between all or most modules
- features - package for feature modules
  - login - login functionality (UI, use cases)
  - profile - profile functionality (UI, use cases)
- navigation - navigation handling logic
- network - api interfaces, response models
