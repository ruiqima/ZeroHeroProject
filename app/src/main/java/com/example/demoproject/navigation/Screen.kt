package com.example.demoproject.navigation

sealed class Screen(val route: String){
    object EventsScreen : Screen("events_screen")
    object VisualizationScreen : Screen("visualization_screen")
    object CreateEventScreen : Screen("creation_screen")
    object SignInScreen : Screen("sign_in_screen")
    object InterestScreen : Screen("interest_screen")
    object InitialScreen : Screen("initial_screen")
}
