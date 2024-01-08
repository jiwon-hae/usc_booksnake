package com.usc.booksnake.presentation

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.usc.booksnake.presentation.features.explore.ExploreScreen
import com.usc.booksnake.presentation.features.library.LibraryScreen
import com.usc.booksnake.presentation.features.lists.ListsScreen
import com.usc.booksnake.presentation.route.BookSnakeNavigationActions
import com.usc.booksnake.presentation.route.BookSnakeRoute
import com.usc.booksnake.presentation.route.BookSnakeTopLevelDestination
import com.usc.booksnake.presentation.route.TOP_LEVEL_DESTINATIONS
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.Secondary

@Composable
fun BookSnake() {
    BookSnakeNavigationWrapper()
}


@Composable
private fun BookSnakeNavigationWrapper() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        BookSnakeNavigationActions(navController)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination =
        navBackStackEntry?.destination?.route ?: BookSnakeRoute.LIBRARY

    BookSnakeAppContents(
        navController = navController,
        selectedDestination = selectedDestination,
        navigateToTopLevelDestination = navigationActions::navigateTo
    )

}

@Composable
private fun BookSnakeAppContents(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigateToTopLevelDestination: (BookSnakeTopLevelDestination) -> Unit,
) {
    Scaffold(
        contentColor = Background,
        containerColor = Background,
        topBar = {
            com.usc.booksnake.presentation.features.home.HomeTopBar(
                modifier
            )
        },
        bottomBar = {
            BookSnakeBottomNavigationBar(
                selectedDestination = selectedDestination,
                navigateToTopLevelDestination = navigateToTopLevelDestination
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
                    ).background(Background)
            ) {
                BookSnakeNavHost(
                    modifier = modifier,
                    navController = navController
                )
            }
        })

}

@Composable
private fun BookSnakeNavHost(
    modifier: Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BookSnakeRoute.LIBRARY
    ) {
        composable(BookSnakeRoute.LIBRARY) {
            LibraryScreen()
        }

        composable(BookSnakeRoute.EXPLORE) {
            ExploreScreen()
        }

        composable(BookSnakeRoute.LISTS) {
            ListsScreen()
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
                selected = selectedDestination == destination.route,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Secondary,
                    selectedTextColor = Secondary,
                    indicatorColor = Color.Transparent
                ),
                onClick = {
                    navigateToTopLevelDestination(destination)
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