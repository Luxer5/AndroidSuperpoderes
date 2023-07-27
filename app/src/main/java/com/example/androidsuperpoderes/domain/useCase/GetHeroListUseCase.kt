package com.example.androidsuperpoderes.domain.useCase

import com.example.androidsuperpoderes.data.HeroRepository
import com.example.androidsuperpoderes.domain.model.HeroModel

class GetHeroListUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke() = heroRepository.getHeroList()

}