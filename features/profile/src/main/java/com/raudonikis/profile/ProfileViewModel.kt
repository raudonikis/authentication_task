package com.raudonikis.profile

import androidx.lifecycle.ViewModel
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
) : ViewModel() {

    /**
     * Events
     */
    fun onLogoutClicked() {
        navigationDispatcher.navigate(NavigationGraph.Login)
    }
}