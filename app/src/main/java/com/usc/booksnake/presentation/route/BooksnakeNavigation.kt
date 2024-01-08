package com.usc.booksnake.presentation.route

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

object BookSnakeRoute {
    const val LIBRARY = "library"
    const val LISTS = "lists"
    const val EXPLORE = "explore"
}

data class BookSnakeTopLevelDestination(
    val route : String,
    val label : String,
    val icon : ImageVector
)


class BookSnakeNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: BookSnakeTopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

val TOP_LEVEL_DESTINATIONS = listOf(
    BookSnakeTopLevelDestination(
        route = BookSnakeRoute.LIBRARY,
        icon = Icons.Filled.List,
        label = "Library"
    ),

    BookSnakeTopLevelDestination(
        route = BookSnakeRoute.LISTS,
        icon = Icons.Filled.List,
        label = "Lists"
    ),
    BookSnakeTopLevelDestination(
        route = BookSnakeRoute.EXPLORE,
        icon = Icons.Filled.Search,
        label = "Explore"
    )
)

