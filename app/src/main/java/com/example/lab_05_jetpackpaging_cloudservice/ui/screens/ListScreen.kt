package com.example.lab_05_jetpackpaging_cloudservice.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.lab_05_jetpackpaging_cloudservice.R
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.DarkGrayColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ImageSizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ListIsEmpty
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.ListTitle
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeLarge
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.AppHeader
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.ScreenTitle
import com.example.lab_05_jetpackpaging_cloudservice.util.composables.SensorLogItem
import com.example.lab_05_jetpackpaging_cloudservice.util.model.MainViewModel

@Composable
fun ListScreen(navController: NavHostController) {

    val viewModel = viewModel<MainViewModel>()
    val state = viewModel.state

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

            LazyColumn(
                contentPadding = PaddingValues(all = 4.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                /* TODO: Temporal iteration. REPLACE with Cloud data */
                items(state.items.size) { i ->
                    val item = state.items[i]

                    if (i >= state.items.size - 1 && !state.endReached && !state.isLoading) {
                        viewModel.loadNextItems()
                    }

                    SensorLogItem(item)
                }

                /* LOAD COMPONENT */
                item {
                    if (state.isLoading) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            CircularProgressIndicator(color = PrimaryColor)
                        }
                    } else {
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
                    }
                }
            }
        }
    }

}