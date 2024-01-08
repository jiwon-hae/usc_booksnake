package com.usc.booksnake.presentation.features.library.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.usc.booksnake.domain.entity.Book

@Composable
fun LibraryItemDetail(
    modifier: Modifier = Modifier,
    book: Book
) {
    Scaffold(
        topBar = { LibraryItemDetailTopBar() }
    ) { paddingValue ->
        Box(
            modifier = modifier.padding(paddingValue)
        ) {
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibraryItemDetailTopBar() {
    TopAppBar(
        navigationIcon = {
            Icon(
                modifier = Modifier.clickable {

                },
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = null
            )
        },
        title = { Text("Library") })
}