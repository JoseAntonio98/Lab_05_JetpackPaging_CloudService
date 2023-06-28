package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ButtonElevation
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterComment
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterDateLabel
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterSaveButton
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterSmokeLabel
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterTimeLabel
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.RegisterTitle
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SecondaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeExtraLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium20
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeP1
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.AppHeader
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.ScreenTitle
import com.example.lab_05_jetpackpaging_cloudservice.util.model.MainViewModel
import com.example.lab_05_jetpackpaging_cloudservice.util.model.SensorLog
import com.example.lab_05_jetpackpaging_cloudservice.util.navigation.Destination
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavHostController) {
    var sensorValue by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current

    val viewModel = viewModel<MainViewModel>()

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

            Spacer(modifier = Modifier.height(SizeMedium20))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SizeMedium)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    value = sensorValue,
                    onValueChange = { sensorValue = it },
                    placeholder = { Text(text = RegisterSmokeLabel) },
                    maxLines = 1,
                    shape = RoundedCornerShape(SizeMedium),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    )
                )

                Spacer(modifier = Modifier.height(SizeMedium20))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    value = date,
                    onValueChange = { date = it },
                    placeholder = { Text(text = RegisterDateLabel) },
                    maxLines = 1,
                    shape = RoundedCornerShape(SizeMedium),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    )
                )

                Spacer(modifier = Modifier.height(SizeMedium20))

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    enabled = true,
                    value = time,
                    onValueChange = { time = it },
                    placeholder = { Text(text = RegisterTimeLabel) },
                    maxLines = 1,
                    shape = RoundedCornerShape(SizeMedium),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    )
                )

                Spacer(modifier = Modifier.height(SizeMedium20))

                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(96.dp),
                    enabled = true,
                    value = comment,
                    onValueChange = { comment = it },
                    placeholder = { Text(text = RegisterComment) },
                    maxLines = 3,
                    shape = RoundedCornerShape(SizeMedium),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Next) }
                    )
                )

                Spacer(modifier = Modifier.height(SizeExtraLarge))
                Spacer(modifier = Modifier.height(SizeExtraLarge))

                Button(
                    colors = ButtonDefaults.buttonColors(
                        contentColor = SecondaryColor,
                        containerColor = PrimaryColor
                    ),
                    elevation = ButtonDefaults.buttonElevation(ButtonElevation),
                    onClick = {
                        val sensorLog = SensorLog(date,time,comment,sensorValue.toDouble())
                        viewModel.create(sensorLog)
                        navController.navigate(Destination.Home.route)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = RegisterSaveButton, color = SecondaryColor, fontSize = TextSizeP1)
                }
            }
        }
    }
}

@OptIn(DelicateCoroutinesApi::class)
private fun insertAsync(viewModel: MainViewModel, sensor: SensorLog) {
    GlobalScope.launch {
        withContext(Dispatchers.IO) {
            viewModel.create(sensor)
        }
    }
}