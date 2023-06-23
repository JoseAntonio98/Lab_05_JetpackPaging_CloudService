package com.example.lab_05_jetpackpaging_cloudservice.util.navigation

sealed class Destination(val title: String, val route: String) {
    object Home : Destination("Home", "home")
    object List : Destination("List", "list")
    object Register : Destination("Register", "register")
}