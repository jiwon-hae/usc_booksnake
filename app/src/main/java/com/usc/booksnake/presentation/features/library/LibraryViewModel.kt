package com.usc.booksnake.presentation.features.library

import androidx.lifecycle.ViewModel
import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.domain.usecase.LibraryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    //private val _useCase : LibraryUseCase
) : ViewModel() {

    private val _libraryState = MutableStateFlow(LibraryUiState())
    val libraryState: StateFlow<LibraryUiState> = _libraryState.asStateFlow()

    fun getBooks(){
        val dummyBooks = List(20) {
            Book(
                title = "title_$it",
                author = "author_$it",
                image = "image_$it"
            )
        }
        _libraryState.value = _libraryState.value.updateBooks(dummyBooks)
    }
}