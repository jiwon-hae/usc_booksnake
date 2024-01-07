package com.usc.booksnake.data.repository

import com.usc.booksnake.data.remote.ExploreRemoteSource
import com.usc.booksnake.domain.repository.ExploreRepository
import javax.inject.Inject

class ExploreRepositoryImpl @Inject constructor(
    private val remoteDataSource: ExploreRemoteSource
) : ExploreRepository {

}