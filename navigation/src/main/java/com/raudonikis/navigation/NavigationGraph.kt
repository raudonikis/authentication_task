package com.raudonikis.navigation

sealed class NavigationGraph {
    object Login : NavigationGraph()
    object Profile : NavigationGraph()
}