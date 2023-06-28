package com.example.lab_05_jetpackpaging_cloudservice.util.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.DarkGrayColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.LightGrayColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.PrimaryColor
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeMedium
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.SizeSmall
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeH4
import com.example.lab_05_jetpackpaging_cloudservice.ui.theme.TextSizeP2
import com.example.lab_05_jetpackpaging_cloudservice.util.model.SensorLog

@Composable
fun SensorLogItem(log: SensorLog) {
    /* TODO: Improve History Items styles */
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(SizeSmall))
            .background(color = LightGrayColor)
            .padding(SizeMedium, SizeSmall)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,

        ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = log.date + " | " + log.time,
                fontWeight = FontWeight.Bold,
                fontSize = TextSizeP2,
                color = DarkGrayColor
            )
            Text(
                text = log.comment,
                fontSize = TextSizeP2,
                color = DarkGrayColor
            )
        }

        Spacer(modifier = Modifier.width(SizeSmall))

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = log.value.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = TextSizeH4,
                color = PrimaryColor
            )
        }
    }
}