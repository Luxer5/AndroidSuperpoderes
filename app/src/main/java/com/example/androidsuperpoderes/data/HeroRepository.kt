package com.example.androidsuperpoderes.data

import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.model.LocationModel

interface HeroRepository {

    suspend fun getHeroList(): List<HeroModel>

    suspend fun getHeroById(id: String): HeroModel

    suspend fun setFavorite(hero: HeroModel)

    suspend fun getLocationList(id:String): List<LocationModel>
}