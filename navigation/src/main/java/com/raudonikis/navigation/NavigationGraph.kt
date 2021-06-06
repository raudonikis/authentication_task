package com.raudonikis.navigation

/**
 * Defines all the possible navigation destination graphs
 * Use [NavigationDispatcher] to navigate between destinations
 */
sealed class NavigationGraph {
    object Login : NavigationGraph()
    object Profile : NavigationGraph()
}