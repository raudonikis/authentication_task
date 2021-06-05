package com.raudonikis.login.ui

sealed class LoginEvent {
    object Loading: LoginEvent()
    object Success: LoginEvent()
    object Failure: LoginEvent()
}