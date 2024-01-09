package com.usc.booksnake.presentation.features.library

import androidx.lifecycle.ViewModel
import com.usc.booksnake.domain.entity.Book
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

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
                contributor = "author_$it",
                imageUrl = "image_$it",
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
        }
        _libraryState.value = _libraryState.value.updateBooks(dummyBooks)
    }

    fun setOpenedBook(book : Book){
        _libraryState.value = _libraryState.value.openLibraryItem(book)
    }

    fun closeBookDetail(){
        _libraryState.value = _libraryState.value.closeBook()
    }
}