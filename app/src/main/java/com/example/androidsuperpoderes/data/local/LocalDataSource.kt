package com.example.androidsuperpoderes.data.local

import com.example.androidsuperpoderes.data.local.model.HeroLocal
import com.example.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHeroList() : List<HeroLocal>

    suspend fun getHeroById(id:String): Flow<HeroLocal>

    suspend fun setFavorite(hero:HeroLocal)
}