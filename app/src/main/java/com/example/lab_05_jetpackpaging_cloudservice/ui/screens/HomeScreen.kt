package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ButtonElevation
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.HomeListButton
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.HomeRegisterButton
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SecondaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeExtraLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium20
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeP1
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.AppLogo
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.CircularBackground
import com.example.lab_05_jetpackpaging_cloudservice.util.navigation.Destination

@Composable
fun HomeScreen(navController: NavHostController) {
    CircularBackground()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = SizeMedium20, vertical = SizeLarge),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppLogo()

        Spacer(modifier = Modifier.height(SizeExtraLarge))
        Spacer(modifier = Modifier.height(SizeExtraLarge))
        Spacer(modifier = Modifier.height(SizeLarge))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SizeLarge)
        ) {
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(ButtonElevation),
                onClick = {
                    navController.navigate(Destination.Register.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = HomeRegisterButton, color = SecondaryColor, fontSize = TextSizeP1)
            }

            Spacer(modifier = Modifier.height(SizeMedium))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(ButtonElevation),
                onClick = {
                    navController.navigate(Destination.List.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = HomeListButton, color = SecondaryColor, fontSize = TextSizeP1)
            }
        }
    }
}