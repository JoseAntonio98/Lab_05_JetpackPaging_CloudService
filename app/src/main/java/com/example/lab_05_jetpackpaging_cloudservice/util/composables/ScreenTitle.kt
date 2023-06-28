package com.example.lab_05_jetpackpaging_cloudservice.util.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeSmall
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeH2

@Composable
fun ScreenTitle(title: String) {
    Text(
        text = title,
        color = PrimaryColor,
        fontSize = TextSizeH2,
        fontWeight = FontWeight.Bold
    )

    Spacer(modifier = Modifier.height(SizeSmall))

    Divider()

    Spacer(modifier = Modifier.height(SizeMedium))
}