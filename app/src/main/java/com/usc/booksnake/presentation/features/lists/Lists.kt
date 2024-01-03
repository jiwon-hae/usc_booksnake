package com.usc.booksnake.presentation.features.lists

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.usc.booksnake.domain.entity.BookList

@Composable
fun ListsScreen(
    modifier: Modifier = Modifier,
    viewModel: ListsViewModel = viewModel()
) {
    viewModel.getBookLists()
    val listsState = viewModel.listsUiState.collectAsState()
    val bookLists = listsState.value.bookLists

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            ListsButton(
                label = "New List",
                icon = Icons.Filled.List,
                onClick = {})
            Spacer(modifier = Modifier.width(10.dp))
            ListsButton(
                label = "Import List",
                icon = Icons.Filled.List,
                onClick = {})
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .background(color = Color.Gray, shape = RoundedCornerShape(5))
                .padding(horizontal = 10.dp, vertical = 5.dp)

        ) {
            bookLists.map { bookList ->
                ListItem(bookList)
            }
        }
    }
}

@Composable
fun ListsButton(label: String, icon: ImageVector, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .background(Color.Blue, shape = RoundedCornerShape(40))
            .padding(horizontal = 15.dp, vertical = 15.dp)
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = Color.White)
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            label,
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun ListItem(bookList: BookList) {
    Row(modifier = Modifier
        .height(120.dp)
        .padding(vertical = 10.dp)) {
        LazyVerticalGrid(
            modifier = Modifier
                .weight(0.3f)
                .align(Alignment.CenterVertically),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(5.dp),
            userScrollEnabled = false
        ) {
            items(4) { index ->
                AsyncImage(
                    model = "https://www.freecovermaker.com/wp-content/uploads/2021/07/Vogue-magazine-cover-3.jpeg",
                    contentDescription = ""
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.025f))
        Column(
            modifier = Modifier
                .weight(0.55f)
        ) {
            Text(bookList.title, fontSize = 18.sp, color = Color.White)
            Text(modifier = Modifier.weight(1f), text = bookList.subTitle, fontSize = 15.sp, color = Color.LightGray)
            Row {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(1.dp))
                Text(bookList.creator, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.weight(0.025f))
        IconButton(
            modifier = Modifier
                .weight(0.1f)
                .align(Alignment.CenterVertically),
            onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = null
            )
        }
    }
}