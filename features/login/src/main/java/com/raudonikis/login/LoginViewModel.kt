package com.raudonikis.login

import androidx.lifecycle.ViewModel
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
) : ViewModel() {

    /**
     * Events
     */
    fun onSubmitClicked() {
        navigationDispatcher.navigate(NavigationGraph.Profile)
    }
}