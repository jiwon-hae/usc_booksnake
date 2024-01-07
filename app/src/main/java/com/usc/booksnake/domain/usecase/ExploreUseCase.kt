package com.usc.booksnake.domain.usecase

import com.usc.booksnake.domain.repository.ExploreRepository
import javax.inject.Inject

interface ExploreUseCase {

}

class ExploreUseCaseImpl @Inject constructor(
    private val exploreRepository: ExploreRepository
)  : ExploreUseCase {

}