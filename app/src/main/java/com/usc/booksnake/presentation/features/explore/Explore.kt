package com.usc.booksnake.presentation.features.explore

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ExploreScreen(
    modifier : Modifier = Modifier,
    viewModel : ExploreViewModel = viewModel()
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore explore "
        )
    }
}

