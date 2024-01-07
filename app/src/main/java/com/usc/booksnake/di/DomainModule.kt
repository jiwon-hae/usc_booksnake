package com.usc.booksnake.di

import com.usc.booksnake.domain.usecase.ExploreUseCase
import com.usc.booksnake.domain.usecase.ExploreUseCaseImpl
import com.usc.booksnake.domain.usecase.LibraryUseCase
import com.usc.booksnake.domain.usecase.LibraryUseCaseImpl
import com.usc.booksnake.domain.usecase.ListsUseCase
import com.usc.booksnake.domain.usecase.ListsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {
    @Binds
    abstract fun bindsLibraryUseCase(
        libraryUseCase: LibraryUseCaseImpl
    ): LibraryUseCase


    @Binds
    abstract fun bindsListsUseCase(
        listsUseCase: ListsUseCaseImpl
    ): ListsUseCase

    @Binds
    abstract fun bindsExploreUseCase(
        exploreUseCase: ExploreUseCaseImpl
    ): ExploreUseCase
}