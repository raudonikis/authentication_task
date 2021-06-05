package com.raudonikis.login

sealed class LoginEvent {
    object Loading: LoginEvent()
    object Success: LoginEvent()
    object Failure: LoginEvent()
}