package com.example.androidsuperpoderes.domain.useCase

import com.example.androidsuperpoderes.data.HeroRepository
import com.example.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.flow.Flow

class GetDetailUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String): Flow<HeroModel> = heroRepository.getHeroById(id)

}