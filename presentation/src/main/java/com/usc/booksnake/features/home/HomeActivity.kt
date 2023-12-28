package com.usc.booksnake.features.home

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.usc.booksnake.theme.BooksnakeTheme


@Composable
fun HomeActivity(modifier: Modifier = Modifier.fillMaxSize()) {
    Text(
        text = "Hello Home!!!",
        modifier = modifier,
    )
}


@Preview(showBackground = true)
@Composable
fun HomeActivityPreview() {
    BooksnakeTheme {
        HomeActivity()
    }
}