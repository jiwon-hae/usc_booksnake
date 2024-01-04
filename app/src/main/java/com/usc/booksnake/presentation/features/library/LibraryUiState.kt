package com.usc.booksnake.presentation.features.library

import com.usc.booksnake.domain.entity.Book

class LibraryUiState(
    val books : List<Book> = emptyList()
) {
    fun updateBooks(books : List<Book>) : LibraryUiState {
        return copyWith(books = books)
    }
    private fun copyWith(
        books : List<Book>
    ) : LibraryUiState {
        return LibraryUiState(books = books)
    }
}