package com.usc.booksnake.domain.usecase


import com.usc.booksnake.domain.repository.ListsRepository
import javax.inject.Inject
import javax.inject.Singleton

interface ListsUseCase {

}

@Singleton
class ListsUseCaseImpl @Inject constructor(
    private val listsRepository: ListsRepository
) : ListsUseCase {
}