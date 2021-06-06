package com.raudonikis.login.ui

/**
 * Defines all possible login events
 */
sealed class LoginEvent {
    object Loading: LoginEvent()
    object Success: LoginEvent()
    object Failure: LoginEvent()
}