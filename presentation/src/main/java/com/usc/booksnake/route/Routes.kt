package com.usc.booksnake.route

import android.app.Activity
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.usc.booksnake.features.MainScreen
import com.usc.booksnake.features.home.HomeScreen
import com.usc.booksnake.model.UiTabItem

@Composable
fun Routes(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val activity = (LocalContext.current as Activity)
    NavHost(
        modifier = modifier.statusBarsPadding(),
        navController = navController, startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen()
        }
    }
}