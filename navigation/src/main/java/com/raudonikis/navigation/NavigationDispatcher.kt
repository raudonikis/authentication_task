package com.raudonikis.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Use to navigate between app destinations
 */
@Singleton
class NavigationDispatcher @Inject constructor() {

    private val _navigationCommands: Channel<NavigationGraph> = Channel(Channel.BUFFERED)
    val navigationCommands: Flow<NavigationGraph> = _navigationCommands.receiveAsFlow()

    fun navigate(command: NavigationGraph) {
        _navigationCommands.trySend(command)
    }
}