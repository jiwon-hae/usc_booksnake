package com.usc.booksnake.presentation.features.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.usc.booksnake.presentation.features.explore.ExploreScreen
import com.usc.booksnake.presentation.features.library.LibraryScreen
import com.usc.booksnake.presentation.features.lists.ListsScreen
import com.usc.booksnake.presentation.route.BookSnakeDestination
import com.usc.booksnake.presentation.route.BookSnakeHomeTab
import com.usc.booksnake.presentation.route.BookSnakeTopLevelDestination
import com.usc.booksnake.presentation.route.TOP_LEVEL_DESTINATIONS
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.Secondary
import java.io.Serializable

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
    selectedTab: BookSnakeHomeTab = BookSnakeHomeTab.Library,
    navigateToDestination: (BookSnakeDestination) -> Unit,
) {

    Scaffold(
        contentColor = Background,
        containerColor = Background,
        topBar = { HomeTopBar(selectedTab = selectedTab) },
        bottomBar = {
            BookSnakeBottomNavigationBar(
                selectedDestination = selectedTab.name,
                navigateToTopLevelDestination = navigateToDestination
            )
        },
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
                    selectedTab = selectedTab,
                    navigateToDestination = navigateToDestination
                )
            }
        })
}

@Composable
private fun HomeContent(
    selectedTab: BookSnakeHomeTab,
    navigateToDestination: (BookSnakeDestination) -> Unit
) {
    when (selectedTab) {
        BookSnakeHomeTab.Library -> LibraryScreen(navigateToDestination = navigateToDestination)
        BookSnakeHomeTab.Lists -> ListsScreen()
        BookSnakeHomeTab.Explore -> ExploreScreen()
    }
}

@OptIn(
    ExperimentalMaterial3Api::class,
)
@Composable
fun HomeTopBar(
    modifier: Modifier = Modifier,
    selectedTab: BookSnakeHomeTab
) {
    val context = LocalContext.current
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Background),
        title = { }, actions = {
            if (selectedTab == BookSnakeHomeTab.Library) {
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

@Composable
fun BookSnakeBottomNavigationBar(
    selectedDestination: String,
    navigateToTopLevelDestination: (BookSnakeTopLevelDestination) -> Unit
) {
    NavigationBar(
        containerColor = Background,
    ) {
        TOP_LEVEL_DESTINATIONS.forEach { destination ->
            NavigationBarItem(
                selected = selectedDestination == destination.label,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Secondary,
                    selectedTextColor = Secondary,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navigateToTopLevelDestination(
                        destination
                    )
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(destination.label)
                }
            )
        }
    }
}