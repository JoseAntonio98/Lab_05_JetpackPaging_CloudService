package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterTitle
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.AppHeader
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.ScreenTitle

@Composable
fun RegisterScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        AppHeader(navController = navController)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(SizeLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScreenTitle(title = RegisterTitle)
        }
    }
}