package com.usc.booksnake.presentation.features.library

import com.usc.booksnake.domain.entity.Book

class LibraryUiState(
    val books: List<Book> = emptyList(),
    val openedBook: Book? = null
) {
    fun updateBooks(books: List<Book>): LibraryUiState {
        return copyWith(books = books)
    }

    fun openLibraryItem(book: Book): LibraryUiState {
        return copyWith(openedBook = book)
    }

    fun closeBook(): LibraryUiState {
        return LibraryUiState(
            books = books,
            openedBook = null
        )
    }

    private fun copyWith(
        books: List<Book>? = null,
        openedBook: Book? = null
    ): LibraryUiState {
        return LibraryUiState(
            books = books ?: this.books,
            openedBook = openedBook ?: this.openedBook
        )
    }
}