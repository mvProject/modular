package com.mvproject.navigation

import androidx.navigation.NavController
import javax.inject.Inject

class Navigator @Inject constructor() {
    lateinit var navController: NavController

    // navigate on main thread or nav component crashes sometimes
    fun navigateToFlow(navigationFlow: NavigationFlow) = when (navigationFlow) {
        NavigationFlow.FirstAppFlow ->
            navController.navigate(MainNavGraphDirections.actionGlobalFirstAppFlow())
        NavigationFlow.SecondAppFlow ->
            navController.navigate(MainNavGraphDirections.actionGlobalSecondAppFlow())
        NavigationFlow.LoginFlow ->
            navController.navigate(MainNavGraphDirections.actionGlobalLoginFlow())
    }
}
