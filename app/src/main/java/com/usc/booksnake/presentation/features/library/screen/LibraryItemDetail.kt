package com.usc.booksnake.presentation.features.library.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.usc.booksnake.core.callbacks.VoidCallback
import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.presentation.features.library.LibraryViewModel
import com.usc.booksnake.presentation.features.widgets.CommonAppBar
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.OnSurface
import com.usc.booksnake.presentation.theme.Secondary
import com.usc.booksnake.presentation.theme.Surface
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LibraryDetailItem(
    modifier: Modifier = Modifier,
    onBackPressed: VoidCallback,
    viewModel: LibraryViewModel = viewModel(),
    book: Book,
) {
    Scaffold(
        modifier = modifier.background(Background),
        topBar = { LibraryItemDetailTopBar(onBackPressed = onBackPressed) }
    ) { paddingValue ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .background(Background)
                .padding(
                    top = paddingValue.calculateTopPadding(),
                    bottom = paddingValue.calculateBottomPadding(),
                    start = 10.dp,
                    end = 10.dp
                )
                .wrapContentHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BookDetailImage(
                book = book
            )
            ViewInYourSpaceButton()
            LibraryDetailContent(title = "Title", contents = book.title)
            LibraryDetailContent(
                title = "Contributor",
                contents = book.contributor
            )
            LibraryDetailContent(
                title = "Created Published",
                contents = book.createdPublished
            )
            LibraryDetailContent(
                title = "Original Format",
                contents = book.originalFormat
            )
            LibraryDetailContent(
                title = "Subjects",
                contents = book.subjects.joinToString(", ")
            )
            LibraryDetailContent(
                title = "Online Format",
                contents = book.onlineFormat.joinToString(", ")
            )
            LibraryDetailContent(
                title = "Item Url",
                contents = book.imageUrl
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookDetailImage(
    modifier: Modifier = Modifier,
    book: Book
) {
    val pagerState: PagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // TODO(jiwonhae) : change the number to actual number
        // book.image.size
        5
    }

    Box {
        HorizontalPager(
            state = pagerState, userScrollEnabled = true,
            contentPadding = PaddingValues(30.dp)
        ) { pageIndex: Int ->
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = "https://www.freecovermaker.com/wp-content/uploads/2021/07/Vogue-magazine-cover-3.jpeg",
                contentDescription = "Translated description of what the image contains"
            )
        }


        Row(
            Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
                .background(Surface, shape = RoundedCornerShape(50))
                .padding(vertical = 5.dp, horizontal = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.White else OnSurface
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
    }
}

@Composable
fun ViewInYourSpaceButton() {
    Divider(color = OnSurface, thickness = 1.dp)
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        modifier = Modifier
            .background(
                Secondary,
                shape = RoundedCornerShape(20)
            )
            .padding(horizontal = 30.dp, vertical = 10.dp),
        text = "View In Your Space",
        color = Color.White
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun LibraryDetailContent(
    modifier: Modifier = Modifier,
    title: String,
    contents: String
) {
    Column(
        modifier = modifier.height(60.dp)
    ) {
        Divider(color = OnSurface)
        Text(text = title, fontSize = 12.sp, color = OnSurface)
        Text(text = contents, fontSize = 15.sp, color = Color.White)
    }
}

@Composable
fun LibraryItemDetailTopBar(
    modifier: Modifier = Modifier,
    onBackPressed: VoidCallback
) {
    CommonAppBar.withBackButton(
        onNavigationIconPressed = onBackPressed,
        title = "Library"
    )
}