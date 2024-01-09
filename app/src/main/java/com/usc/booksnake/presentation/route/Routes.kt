package com.usc.booksnake.presentation.route


object BookSnakeRoute {
    const val HOME = "home/{tab}"
    const val LIBRARY_DETAIL = "library_detail"
}

object BookSnakeHomeTabRoute {
    const val Library = "home/library"
    const val Lists = "home/lists"
    const val Explore = "home/explore"
}

enum class BookSnakeHomeTab {
    Library,
    Lists,
    Explore
}
