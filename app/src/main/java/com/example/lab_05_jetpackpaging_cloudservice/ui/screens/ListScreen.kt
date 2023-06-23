package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.R
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.DarkGrayColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ImageSizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ListIsEmpty
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ListTitle
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.AppHeader
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.ScreenTitle
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.SensorLogItem

data class SensorLog(val date: String, val time: String, val comment: String, val value: Int)

@Composable
fun ListScreen(navController: NavHostController) {
    // val sensorValuesList = emptyList<SensorLog>()
    val sensorValuesList = (1..10).map {
        SensorLog(
            date = "Date $it",
            time = "Time $it",
            comment = "Comment   $it",
            value = it
        )
    }

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
            ScreenTitle(title = ListTitle)

            if (sensorValuesList.isEmpty()) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.history_empty),
                        contentDescription = ListIsEmpty,
                        modifier = Modifier.width(ImageSizeLarge)
                    )

                    Spacer(modifier = Modifier.height(SizeMedium))

                    Text(text = ListIsEmpty, color = DarkGrayColor)
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(all = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    /* TODO: Temporal iteration. REPLACE with Cloud data */
                    items(sensorValuesList.size) {
                        SensorLogItem()
                    }
                }
            }
        }
    }

}