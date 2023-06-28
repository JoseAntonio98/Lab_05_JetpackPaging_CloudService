package com.example.lab_05_jetpackpaging_cloudservice.util.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.AppHeaderBack
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.AppName
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SecondaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeTopBar
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeH1
import com.example.lab_05_jetpackpaging_cloudservice.util.navigation.Destination

@Composable
fun AppHeader(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(SizeTopBar)
            .background(PrimaryColor)
            .padding(SizeMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.KeyboardArrowLeft,
            contentDescription = AppHeaderBack,
            tint = SecondaryColor,
            modifier = Modifier
                .size(SizeLarge)
                .clickable {
                    navController.navigate(Destination.Home.route)
                }
        )

        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = AppName,
                fontSize = TextSizeH1,
                color = SecondaryColor,
                fontWeight = FontWeight.Bold
            )
        }
    }
}