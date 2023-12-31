@file:OptIn(ExperimentalMaterial3Api::class)

package com.usc.booksnake.features.main

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.usc.booksnake.theme.BooksnakeTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel()
) {
    val mainUiState by mainViewModel.uiState.collectAsState()

    Scaffold(
        topBar = { MainTopBar(mainUiState) },
        bottomBar = { MainBottomBar(mainViewModel, mainUiState) },
    ) { paddingValue ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            MainBody(state = mainUiState)
        }
    }
}

@Composable
fun MainTopBar(state: MainUiState) {
    TopAppBar(title = { Text(state.currentTab.name) })
}

@Composable
fun MainBody(state: MainUiState) {
    Text(state.currentTab.name)
}


@Composable
fun MainBottomBar(viewModel: MainViewModel, state: MainUiState) {
    Button(onClick = { viewModel.increaseNumber() }) {
        Text(state.count.toString())
    }
}

@Composable
@Preview(showBackground = true)
fun previewMainActivity() {
    BooksnakeTheme {
        MainScreen()
    }
}