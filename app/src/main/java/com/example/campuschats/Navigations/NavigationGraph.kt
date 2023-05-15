package com.example.campuschats.Navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.campuschats.Activity.authorizationActivityFun
import com.example.campuschats.Activity.initialActivityFun
import com.example.campuschats.Activity.profileActivityFunc

@Composable
fun sutupNavGraph(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController,
    startDestination = NavigationActions.Initial.route)
    {
        composable(route = NavigationActions.Initial.route) {
            initialActivityFun(navController = navHostController)
        }

        composable(route = NavigationActions.Authorization.route) {
            authorizationActivityFun()
        }

        composable(route = NavigationActions.Profile.route) {
            profileActivityFunc()
        }
    }
    
}