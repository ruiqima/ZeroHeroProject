package com.example.demoproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.demoproject.screens.CreateEventScreen
import com.example.demoproject.screens.EventsScreen
import com.example.demoproject.screens.InitialScreen
import com.example.demoproject.screens.InterestScreen
import com.example.demoproject.screens.VisualizationScreen
import com.example.demoproject.screens.SignInScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.SignInScreen.route){
        composable(route = Screen.EventsScreen.route){ entry ->
            EventsScreen(navController, entry)
        }
        composable(route = Screen.VisualizationScreen.route){
            VisualizationScreen(navController)
        }
        composable(route = Screen.CreateEventScreen.route){
            CreateEventScreen(navController)
        }
        composable(route = Screen.SignInScreen.route){
            SignInScreen(navController)
        }
        composable(route = Screen.InterestScreen.route){
            InterestScreen(navController)
        }
        composable(route = Screen.InitialScreen.route){
            InitialScreen(navController)
        }
    }
}