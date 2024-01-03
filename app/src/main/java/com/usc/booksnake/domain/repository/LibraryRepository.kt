package com.usc.booksnake.domain.repository

import com.usc.booksnake.domain.entity.Book

interface LibraryRepository {
    fun getBooks() : List<Book>{
        return emptyList()
    }
}