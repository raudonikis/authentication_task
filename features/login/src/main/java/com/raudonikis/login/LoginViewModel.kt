package com.raudonikis.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigationDispatcher: NavigationDispatcher,
    private val loginUseCase: LoginUseCase,
) : ViewModel() {

    private val _loginEvent: MutableSharedFlow<LoginEvent> = MutableSharedFlow()

    /**
     * Observables
     */
    val loginEvent: SharedFlow<LoginEvent> = _loginEvent

    /**
     * Events
     */
    fun onSubmitClicked(username: String?, password: String?) {
        viewModelScope.launch {
            if (username.isNullOrBlank() || password.isNullOrBlank()) {
                _loginEvent.emit(LoginEvent.Failure)
                return@launch
            }
            _loginEvent.emit(LoginEvent.Loading)
            loginUseCase.login(username, password)
                .onSuccess {
                    _loginEvent.emit(LoginEvent.Success)
                    navigateToProfile()
                }
                .onFailure { _loginEvent.emit(LoginEvent.Failure) }
        }
    }

    /**
     * Navigation
     */
    private fun navigateToProfile() {
        navigationDispatcher.navigate(NavigationGraph.Profile)
    }
}