package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.Lab_05_JetpackPaging_CloudServiceTheme
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SecondaryColor
import com.example.lab_05_jetpackpaging_cloudservice.util.navigation.NavigationAppHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_05_JetpackPaging_CloudServiceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = SecondaryColor
                    // color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}
