package com.raudonikis.authentication_task

import androidx.lifecycle.ViewModel
import com.raudonikis.auth.AuthenticationPreferences
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    authenticationPreferences: AuthenticationPreferences,
) : ViewModel() {

    /**
     * Observables
     */
    val navigationCommands: Flow<NavigationGraph> = navigationDispatcher.navigationCommands

    /**
     * Check if user is already authenticated, navigate to profile if true
     */
    init {
        if (authenticationPreferences.isUserAuthenticated()) {
            navigateToProfile()
        }
    }

    /**
     * Navigation
     */
    private fun navigateToProfile() {
        navigationDispatcher.navigate(NavigationGraph.Profile)
    }
}