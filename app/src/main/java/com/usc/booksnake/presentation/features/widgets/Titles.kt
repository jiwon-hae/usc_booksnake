package com.usc.booksnake.presentation.features.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Title(title: String) {
    Text(title, fontSize = 30.sp)
}

@Composable
fun SubTitle(subtitle: String) {
    Text(
        modifier = Modifier.padding(start = 10.dp),
        text = subtitle.uppercase(),
        fontSize = 10.sp
    )
}