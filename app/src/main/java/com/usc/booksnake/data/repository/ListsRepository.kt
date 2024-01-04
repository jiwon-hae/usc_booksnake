package com.usc.booksnake.data.repository

import com.usc.booksnake.data.remote.LibraryRemoteDataSource
import com.usc.booksnake.domain.repository.ListsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ListsRepositoryImpl @Inject constructor(
    private val remoteDataSource: LibraryRemoteDataSource
) : ListsRepository {
}