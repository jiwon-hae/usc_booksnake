package com.usc.booksnake.data.repository

import com.usc.booksnake.data.remote.LibraryRemoteDataSource
import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.domain.repository.LibraryRepository
import javax.inject.Inject

class LibraryRepositoryImpl @Inject constructor(
    private val remoteDataSource : LibraryRemoteDataSource
) : LibraryRepository {
    override fun getBooks(): List<Book> {
        return emptyList()
    }
}