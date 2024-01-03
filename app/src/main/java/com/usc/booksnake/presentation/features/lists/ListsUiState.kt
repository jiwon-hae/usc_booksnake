package com.usc.booksnake.presentation.features.lists

import com.usc.booksnake.domain.entity.BookList

class ListsUiState(
    val bookLists: List<BookList> = emptyList()
) {
    fun updateBookList(
        bookLists: List<BookList>
    ): ListsUiState {
        return copyWith(bookLists = bookLists)
    }

    private fun copyWith(
        bookLists: List<BookList>? = null

    ): ListsUiState {
        return ListsUiState(bookLists ?: this.bookLists)
    }
}