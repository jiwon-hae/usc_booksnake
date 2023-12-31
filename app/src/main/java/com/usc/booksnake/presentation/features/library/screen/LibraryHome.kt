package com.usc.booksnake.presentation.features.library.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.presentation.features.library.LibraryViewModel
import com.usc.booksnake.presentation.features.widgets.SubTitle
import com.usc.booksnake.presentation.route.BookSnakeDestination
import com.usc.booksnake.presentation.route.BookSnakeRoute
import com.usc.booksnake.presentation.route.BookSnakeTopLevelDestination
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.OnSurface
import com.usc.booksnake.presentation.theme.Surface
import java.io.Serializable

@Composable
fun LibraryHome(
    modifier: Modifier = Modifier,
    viewModel: LibraryViewModel,
    navigateToTopLevelDestination: (BookSnakeDestination) -> Unit
) {
    val libraryState = viewModel.libraryState.collectAsState().value
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Spacer(modifier = modifier.height(10.dp))
        SubTitle(subtitle = "library")
        Spacer(modifier = modifier.height(10.dp))
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(Surface, shape = RoundedCornerShape(5))
        ) {
            libraryState.books.forEach { book ->
                LibraryItem(book = book, onBookSelected = { selectedBook ->
                    viewModel.setOpenedBook(selectedBook)
                    navigateToTopLevelDestination.invoke(BookSnakeDestination(route =
                    BookSnakeRoute.LIBRARY_DETAIL))
                })
            }
        }
    }
}


@Composable
fun LibraryItem(
    book: Book,
    onBookSelected: (book: Book) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .clickable {
                onBookSelected(book)
            }
    ) {
        AsyncImage(
            modifier = Modifier
                .weight(0.2f)
                .size(70.dp),
            model = "https://www.freecovermaker.com/wp-content/uploads/2021/07/Vogue-magazine-cover-3.jpeg",
            contentDescription = "Translated description of what the image contains"
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            modifier = Modifier
                .weight(0.8f)
                .align(Alignment.CenterVertically),
            fontSize = 15.sp,
            text = book.title,
            color = Color.White
        )
        Spacer(modifier = Modifier.width(5.dp))
        IconButton(
            modifier = Modifier
                .weight(0.1f)
                .align(Alignment.CenterVertically),
            onClick = {
                onBookSelected(book)
            }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null,
                tint = OnSurface
            )
        }
    }
}