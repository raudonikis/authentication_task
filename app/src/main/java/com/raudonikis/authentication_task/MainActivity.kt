package com.raudonikis.authentication_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.raudonikis.navigation.NavigationDispatcher
import com.raudonikis.navigation.NavigationGraph
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher
    private val navController: NavController
        get() = findNavController(R.id.nav_host_fragment)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        lifecycleScope.launchWhenCreated {
            navigationDispatcher.navigationCommands
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