package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.tools.FillDatabase
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ButtonElevation
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.FillDatabaseButton
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.HomeListButton
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.HomeRegisterButton
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SecondaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeExtraLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium20
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeSmall
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeP1
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.AppLogo
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.CircularBackground
import com.example.lab_05_jetpackpaging_cloudservice.util.model.MainViewModel
import com.example.lab_05_jetpackpaging_cloudservice.util.navigation.Destination
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@Composable
fun HomeScreen(navController: NavHostController) {
    CircularBackground()

    val viewModel = viewModel<MainViewModel>()
    val context = LocalContext.current

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
                Icon(
                    Icons.Default.Edit,
                    contentDescription = HomeRegisterButton,
                    tint = SecondaryColor,
                    modifier = Modifier.size(SizeMedium20)
                )

                Spacer(modifier = Modifier.width(SizeSmall))

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
                Icon(
                    Icons.Default.List,
                    contentDescription = HomeListButton,
                    tint = SecondaryColor,
                    modifier = Modifier.size(SizeMedium20)
                )

                Spacer(modifier = Modifier.width(SizeSmall))

                Text(text = HomeListButton, color = SecondaryColor, fontSize = TextSizeP1)
            }

            Spacer(modifier = Modifier.height(SizeMedium))

            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = SecondaryColor,
                    containerColor = PrimaryColor
                ),
                elevation = ButtonDefaults.buttonElevation(ButtonElevation),
                onClick = {
                    //Comentando la funcion que permitio llenar la base de datos de AWS
                    //insertAsync(context, viewModel)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = FillDatabaseButton, color = SecondaryColor, fontSize = TextSizeP1)
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun insertAsync(context: Context, viewModel: MainViewModel) {
    GlobalScope.launch {
        withContext(Dispatchers.IO) {
            FillDatabase.readAndParseFile(context, viewModel, "data/sensor_data.json")
        }
    }
}