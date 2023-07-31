package com.example.androidsuperpoderes.data

import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow

interface HeroRepository {

    suspend fun getHeroList(): List<HeroModel>

    suspend fun getHeroById(id: String): Flow<HeroModel>

    suspend fun setFavorite(hero: HeroModel)

    suspend fun getLocationList(id:String): List<LocationModel>
}