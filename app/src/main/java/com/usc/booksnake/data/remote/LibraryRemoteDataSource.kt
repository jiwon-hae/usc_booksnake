package com.usc.booksnake.data.remote

import com.usc.booksnake.data.model.DtBookModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LibraryRemoteDataSource @Inject constructor() {
    fun getBooks(): List<DtBookModel> {
        return emptyList()
    }
}