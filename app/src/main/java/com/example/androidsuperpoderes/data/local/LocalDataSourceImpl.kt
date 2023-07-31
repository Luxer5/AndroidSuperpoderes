package com.example.androidsuperpoderes.data.local

import com.example.androidsuperpoderes.data.local.model.HeroLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LocalDataSourceImpl(
    private val heroDao: HeroDao
): LocalDataSource {
    override suspend fun insertHeroList(heroList: List<HeroLocal>) {
        heroDao.insertAll(heroList)
    }

    override suspend fun getHeroList(): List<HeroLocal> = heroDao.getAll()
    override suspend fun getHeroById(id: String): Flow<HeroLocal> = flow {
        emit(heroDao.getHeroById(id ))
    }
    override suspend fun setFavorite(hero: HeroLocal) = heroDao.setFavorite(hero)



}