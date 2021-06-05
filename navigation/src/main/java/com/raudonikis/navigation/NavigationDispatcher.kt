package com.raudonikis.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NavigationDispatcher @Inject constructor(){

    private val _navigationCommands: Channel<String> = Channel()
    val navigationCommands: Flow<String> = _navigationCommands.receiveAsFlow()

    fun navigate(command: String) {
        _navigationCommands.offer(command)
    }
}