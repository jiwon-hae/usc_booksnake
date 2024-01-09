package com.usc.booksnake.presentation.features.library

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.usc.booksnake.presentation.features.library.screen.LibraryHome
import com.usc.booksnake.presentation.route.BookSnakeDestination
import java.io.Serializable

@Composable
fun LibraryScreen(
    modifier: Modifier = Modifier,
    viewModel: LibraryViewModel = viewModel(),
    navigateToDestination: (BookSnakeDestination) -> Unit
) {
    viewModel.getBooks()
    LibraryHome(viewModel = viewModel, navigateToTopLevelDestination = navigateToDestination)
}
