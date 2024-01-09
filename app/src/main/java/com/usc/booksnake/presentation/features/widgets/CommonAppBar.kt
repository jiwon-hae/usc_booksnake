package com.usc.booksnake.presentation.features.widgets

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.usc.booksnake.core.callbacks.VoidCallback
import com.usc.booksnake.presentation.theme.Background
import com.usc.booksnake.presentation.theme.Secondary


data class Action(
    val icon: ImageVector,
    val onClickAction: VoidCallback
)

object CommonAppBar {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    private fun BookSnakeTopBar(
        navigationIcon: ImageVector,
        onNavigationIconPressed: VoidCallback,
        title: String,
        actions: List<Action>
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Background),
            navigationIcon = {
                IconButton(onClick = onNavigationIconPressed) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = null,
                        tint = Secondary
                    )
                }

            },
            title = { Text(text = title, color = Secondary) },
            actions = {
                actions.forEach { it ->
                    IconButton(
                        onClick = { /* do something */ }) {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = "Localized description",
                            tint = Secondary
                        )
                    }
                }
            })
    }

    @Composable
    fun build(
        navigationIcon: ImageVector,
        onNavigationIconPressed: VoidCallback,
        title: String,
        actions: List<Action> = emptyList()
    ) {
        BookSnakeTopBar(
            navigationIcon = navigationIcon,
            onNavigationIconPressed = onNavigationIconPressed,
            title = title,
            actions = actions
        )
    }

    @Composable
    fun withBackButton(
        onNavigationIconPressed: VoidCallback,
        title: String,
        actions: List<Action> = emptyList()
    ) {
        BookSnakeTopBar(
            navigationIcon = Icons.Filled.KeyboardArrowLeft,
            onNavigationIconPressed = onNavigationIconPressed,
            title = title,
            actions = actions
        )
    }

}