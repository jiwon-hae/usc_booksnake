package com.usc.booksnake.presentation.features

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.usc.booksnake.presentation.route.Routes
import com.usc.booksnake.presentation.theme.BookSnakeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BookSnakeTheme {
                MainScreen()
            }
        }
    }
}
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Routes(
        navController = navController
    )
}