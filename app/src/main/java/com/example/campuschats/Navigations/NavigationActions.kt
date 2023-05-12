package com.example.campuschats.Navigations

sealed class NavigationActions(val route: String) {
    object Initial: NavigationActions("initial_activity")
    object Authorization: NavigationActions("main_activity")
}
