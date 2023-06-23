package com.example.lab_05_jetpackpaging_cloudservice.util.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab_05_jetpackpaging_cloudservice.ui.screens.HomeScreen
import com.example.lab_05_jetpackpaging_cloudservice.ui.screens.ListScreen
import com.example.lab_05_jetpackpaging_cloudservice.ui.screens.RegisterScreen

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Destination.Home.route) {
        composable(Destination.Home.route) { HomeScreen(navController = navController) }
        composable(Destination.Register.route) { RegisterScreen(navController = navController) }
        composable(Destination.List.route) { ListScreen(navController = navController) }
    }
}