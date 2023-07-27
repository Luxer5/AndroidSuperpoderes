package com.example.androidsuperpoderes.domain.useCase

import com.example.androidsuperpoderes.data.HeroRepository

class GetDetailUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String) = heroRepository.getHeroById(id)

}