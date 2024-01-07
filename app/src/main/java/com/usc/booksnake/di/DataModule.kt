package com.usc.booksnake.di

import com.usc.booksnake.data.repository.ExploreRepositoryImpl
import com.usc.booksnake.data.repository.LibraryRepositoryImpl
import com.usc.booksnake.data.repository.ListsRepositoryImpl
import com.usc.booksnake.domain.repository.ExploreRepository
import com.usc.booksnake.domain.repository.LibraryRepository
import com.usc.booksnake.domain.repository.ListsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindsLibraryRepository(
        libraryRepository: LibraryRepositoryImpl
    ): LibraryRepository


    @Binds
    abstract fun bindsListsRepository(
        listsRepository: ListsRepositoryImpl
    ): ListsRepository

    @Binds
    abstract fun bindsExploreRepository(
        exploreRepository: ExploreRepositoryImpl
    ): ExploreRepository
}