package com.silva.contact_rename.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DayCheckBox(
    day: String,
    selected: Boolean,
    onChecked: () -> Unit
) {
    val colorDay = if (selected) MaterialTheme.colors.primary else Color.LightGray
    val textColorDay = if (selected) Color.White else Color.Black
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .width(30.dp)
            .height(30.dp)
            .background(colorDay)
            .clickable { onChecked() }
    ){
        Text(
            text = day,
            fontSize = 15.sp,
            color = textColorDay
        )
    }
}


@Preview(
    showBackground = true
)
@Composable
fun DayCheckBoxPrev() {
    MaterialTheme {
        DayCheckBox("L", true){

        }
    }
}