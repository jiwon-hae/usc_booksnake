package com.usc.booksnake.presentation.features.home

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.usc.booksnake.presentation.features.explore.ExploreScreen
import com.usc.booksnake.presentation.features.library.LibraryScreen
import com.usc.booksnake.presentation.features.lists.ListsScreen
import com.usc.booksnake.presentation.features.widgets.Title
import com.usc.booksnake.presentation.model.UiTabItem
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.BookSnakeTheme
import com.usc.booksnake.presentation.theme.Secondary
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    initialPageIndex: Int = UiTabItem.Library.ordinal
) {
    val pagerState: PagerState = rememberPagerState(
        initialPage = initialPageIndex,
        initialPageOffsetFraction = 0f
    ) {
        UiTabItem.entries.size
    }

    Scaffold(
        contentColor = Background,
        containerColor = Background,
        topBar = { HomeTopBar(modifier, pagerState) },
        bottomBar = { HomeBottomBar(pagerState = pagerState) },
        content = { padding ->
            Surface(
                modifier = Modifier
                    .padding(
                        top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding(),
                        start = 10.dp,
                        end = 10.dp
                    )
            ) {
                HomeContent(
                    pagerState = pagerState
                )
            }
        })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun HomeContent(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(0.dp),
        state = pagerState, userScrollEnabled = false
    ) { pageIndex: Int ->
        Column(
            modifier = Modifier.background(Background)
        ) {
            Title(title = UiTabItem.entries[pageIndex].name)
            when (pageIndex) {
                UiTabItem.Library.ordinal -> LibraryScreen()
                UiTabItem.Lists.ordinal -> ListsScreen()
                UiTabItem.Explore.ordinal -> ExploreScreen()
            }
        }
    }
}

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class
)
@Composable
fun HomeTopBar(modifier: Modifier, pagerState: PagerState) {
    val context = LocalContext.current
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Background),
        title = { }, actions = {
            if (pagerState.currentPage == 0) {
                IconButton(
                    onClick = { /* do something */ }) {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Localized description",
                        tint = Secondary
                    )
                }
            }
            Text(modifier = modifier.clickable {
                Toast.makeText(
                    context,
                    "Report a bug",
                    Toast.LENGTH_LONG
                )
            }, text = "Report a Bug", color = Secondary)
        })
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeBottomBar(pagerState: PagerState) {
    val coroutineScope = rememberCoroutineScope()

    val tabs = listOf(
        UiTabItem.Library,
        UiTabItem.Lists,
        UiTabItem.Explore
    )

    NavigationBar(
        containerColor = Background,
    ){
        tabs.forEachIndexed { index, tab ->
            NavigationBarItem(
                selected = pagerState.currentPage == index,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Secondary,
                    selectedTextColor = Secondary,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    coroutineScope.launch {
                        pagerState.scrollToPage(
                            index
                        )
                    }
                },
                icon = {
                    Icon(
                        imageVector = tab.icon,
                        contentDescription = tab.label
                    )
                },
                label = {
                    Text(tab.label)
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = false)
fun previewHomeScreen() {
    BookSnakeTheme {
        HomeScreen()
    }
}