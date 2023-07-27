package com.example.androidsuperpoderes.domain.useCase

import com.example.androidsuperpoderes.data.HeroRepository
import com.example.androidsuperpoderes.domain.model.LocationModel

class GetHeroLocationUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String): LocationModel {
        val result = heroRepository.getLocationList(id)

        //Get Last
        //Recorrer la lista comparando el objeto de tipo date
        return result.last()
    }
}