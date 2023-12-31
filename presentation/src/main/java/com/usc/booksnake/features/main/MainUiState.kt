package com.usc.booksnake.features.main

data class MainUiState(
    val currentTab: Tab = Tab.Library,
    val count : Int = 0
) {
    fun increase() : MainUiState {
        return _copyWith(count = (count + 1) % 3)
    }

    private fun _copyWith(tab: Tab? = null, count : Int? = null): MainUiState {
        return MainUiState(
            currentTab = tab ?: currentTab,
            count = count ?: this.count
        )
    }
}

enum class Tab {
    Library,
    Lists,
    Explore
}