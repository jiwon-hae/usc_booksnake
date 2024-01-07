package com.usc.booksnake.presentation.features.widgets

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.usc.booksnake.presentation.theme.OnSurface

@Composable
fun Title(title: String) {
    Text(title, fontSize = 30.sp, color = Color.White)
}

@Composable
fun SubTitle(subtitle: String) {
    Text(
        modifier = Modifier.padding(start = 10.dp),
        text = subtitle.uppercase(),
        fontSize = 15.sp,
        color = OnSurface
    )
}