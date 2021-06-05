package com.raudonikis.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raudonikis.auth.AuthenticationPreferences
import com.raudonikis.common.Outcome
import com.raudonikis.profile.user.User
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import com.raudonikis.profile.user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    private val authenticationPreferences: AuthenticationPreferences,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _user: MutableStateFlow<Outcome<User>> = MutableStateFlow(Outcome.Loading)

    /**
     * Observables
     */
    val user: StateFlow<Outcome<User>> = _user

    /**
     * On init, get current user data
     */
    init {
        viewModelScope.launch {
            _user.value = getUserUseCase.getUser()
        }
    }

    /**
     * Events
     */
    fun onLogoutClicked() {
        authenticationPreferences.clearUserData()
        navigationDispatcher.navigate(NavigationGraph.Login)
    }
}