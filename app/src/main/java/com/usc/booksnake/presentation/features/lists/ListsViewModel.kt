package com.usc.booksnake.presentation.features.lists

import androidx.lifecycle.ViewModel
import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.domain.entity.BookList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ListsViewModel @Inject constructor() : ViewModel() {

    private val _listsUiState = MutableStateFlow(ListsUiState())
    val listsUiState: StateFlow<ListsUiState> = _listsUiState.asStateFlow()

    fun getBookLists() {
        val dummyBookList = List(3) {
            BookList(
                title = "ListTitle$it",
                subTitle = "ListSubTitle$it",
                creator = "Creator",
                itemList = List(2) {
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
            )
        }

        _listsUiState.value = _listsUiState.value.updateBookList(dummyBookList)
    }
}