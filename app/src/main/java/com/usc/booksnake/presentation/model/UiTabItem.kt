package com.usc.booksnake.presentation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

enum class UiTabItem(
    val label : String,
    val icon : ImageVector
) {
    Library(label = "Library", icon = Icons.Filled.List),
    Lists(label = "Lists", icon = Icons.Filled.List),
    Explore(label = "Lists", icon = Icons.Filled.Search)
}