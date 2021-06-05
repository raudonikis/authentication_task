package com.raudonikis.profile

import androidx.lifecycle.ViewModel
import com.raudonikis.data_domain.AuthenticationPreferences
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    private val authenticationPreferences: AuthenticationPreferences,
) : ViewModel() {

    /**
     * Events
     */
    fun onLogoutClicked() {
        authenticationPreferences.clearUserData()
        navigationDispatcher.navigate(NavigationGraph.Login)
    }
}