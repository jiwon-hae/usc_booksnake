package com.usc.booksnake.presentation.route

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.presentation.features.home.HomeScreen
import com.usc.booksnake.presentation.features.library.screen.LibraryDetailItem
import com.usc.booksnake.util.customGetSerializable
import java.io.Serializable


open class BookSnakeDestination(
    open val route: String
)

data class BookSnakeTopLevelDestination(
    override val route: String,
    val label: String,
    val icon: ImageVector
) : BookSnakeDestination(route)

class BookSnakeNavigationActions(private val navController: NavHostController) {
    fun navigateTo(
        destination: BookSnakeDestination,
    ) {
        navController.navigate(destination.route)
        {
            if (destination::class == BookSnakeTopLevelDestination::class) {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
            }
        }
    }
}


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun BookSnakeNavigationWrapper() {
    val navController = rememberNavController()
    val navigationActions = remember(navController) {
        BookSnakeNavigationActions(navController)
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination =
        navBackStackEntry?.destination?.route ?: BookSnakeRoute.HOME

    BookSnakeNavigationGraph(
        navController = navController,
        selectedDestination = selectedDestination,
        navigateToDestination = navigationActions::navigateTo
    )

}

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun BookSnakeNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigateToDestination: (destination: BookSnakeDestination) -> Unit

) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = BookSnakeRoute.HOME
    ) {
        composable(
            BookSnakeRoute.HOME,
            arguments = listOf(navArgument("tab") { type = NavType.StringType })
        ) { backStackEntry ->
            val selectedTab = BookSnakeHomeTab.valueOf(
                backStackEntry.arguments?.getString("tab")
                    ?.replaceFirstChar { it.uppercase() }
                    ?: BookSnakeHomeTab.Library.name
            )
            HomeScreen(
                navigateToDestination = navigateToDestination,
                selectedTab = selectedTab
            )
        }

        composable(BookSnakeRoute.LIBRARY_DETAIL) { backStackEntry ->
            LibraryDetailItem(
                onBackPressed = {
                    navController.navigate(BookSnakeHomeTabRoute.Library)
                }, book = Book(
                    title = "title_0",
                    contributor = "author_0",
                    imageUrl = "image_0",
                    image = emptyList(),
                    originalFormat = "newspaper",
                    subjects = listOf(
                        "inyo county", "newspaper", "japanese"
                    ),
                    createdPublished = "Manzanar, Calif, July 3, 1943",
                    onlineFormat = listOf(
                        "image", "pdf", "online text"
                    ),
                )
            )
        }
    }
}


val TOP_LEVEL_DESTINATIONS = listOf(
    BookSnakeTopLevelDestination(
        route = BookSnakeHomeTabRoute.Library,
        icon = Icons.Filled.List,
        label = "Library"
    ),

    BookSnakeTopLevelDestination(
        route = BookSnakeHomeTabRoute.Lists,
        icon = Icons.Filled.List,
        label = "Lists"
    ),
    BookSnakeTopLevelDestination(
        route = BookSnakeHomeTabRoute.Explore,
        icon = Icons.Filled.Search,
        label = "Explore"
    )
)



