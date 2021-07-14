package com.raudonikis.authentication_task

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private val navController: NavController
        get() = findNavController(R.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigation()

    }

    private fun setUpNavigation() {
        lifecycleScope.launchWhenCreated {
            viewModel.navigationCommands
                .onEach { onNavigationCommand(it) }
                .collect()
        }
    }

    private fun onNavigationCommand(navigationCommand: NavigationGraph) {
        when (navigationCommand) {
            is NavigationGraph.Profile -> {
                navController.navigate(R.id.action_global_navigation_profile)
            }
            is NavigationGraph.Login -> {
                navController.navigate(R.id.action_global_navigation_login)
            }
        }
    }
}