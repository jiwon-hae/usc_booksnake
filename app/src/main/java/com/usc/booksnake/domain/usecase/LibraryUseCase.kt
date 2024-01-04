package com.usc.booksnake.domain.usecase

import com.usc.booksnake.domain.entity.Book
import com.usc.booksnake.domain.repository.LibraryRepository
import javax.inject.Inject


interface LibraryUseCase {
    fun getBooks(
        title : String? = null,
        author : String? = null,
    ) : List<Book>
}
class LibraryUseCaseImpl @Inject constructor(
    private val libraryRepository: LibraryRepository
) : LibraryUseCase {
    override fun getBooks(title: String?, author: String?): List<Book> {
        return libraryRepository.getBooks()
    }
}