package com.example.androidsuperpoderes.domain.useCase

import com.example.androidsuperpoderes.data.HeroRepository
import com.example.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.flow.Flow

class GetHeroListUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke() : Flow<List<HeroModel>> = heroRepository.getHeroList()

}