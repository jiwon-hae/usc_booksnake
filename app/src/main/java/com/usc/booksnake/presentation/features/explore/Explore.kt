package com.usc.booksnake.presentation.features.explore

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.Tertiary

@Composable
fun ExploreScreen(
    modifier: Modifier = Modifier,
    viewModel: ExploreViewModel = viewModel()
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Background),
    ) {
        LibraryOfCongressButton()
    }
}

@Composable
fun LibraryOfCongressButton() {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp

    TextButton(
        modifier = Modifier
            .background(
                color = Tertiary,
                shape = RoundedCornerShape(15)
            )
            .height(height = 150.dp)
            .width(width = (screenWidth * 0.9).dp),
        onClick = { /*TODO*/ }) {
        Text(
            text = "Library of Congress",
            color = Color.White,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
        )
    }
}

