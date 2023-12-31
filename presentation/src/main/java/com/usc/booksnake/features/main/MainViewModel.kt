package com.usc.booksnake.features.main

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    fun increaseNumber(){
        _uiState.value = uiState.value.increase()
        _uiState.value = uiState.value.copy(currentTab = Tab.entries.get(uiState.value.count))
    }
    fun onTabPressed(tab: Tab) {
        _uiState.value = _uiState.value.copy(currentTab = tab)
    }
}