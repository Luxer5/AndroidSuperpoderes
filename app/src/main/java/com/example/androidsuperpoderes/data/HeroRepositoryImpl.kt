package com.example.androidsuperpoderes.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.androidsuperpoderes.data.local.LocalDataSource
import com.example.androidsuperpoderes.data.remote.RemoteDataSource
import com.example.androidsuperpoderes.domain.model.HeroIdModel
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.model.LocationModel
import toHeroLocal
import toHeroModel
import toLocationModel

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): HeroRepository {

    override suspend fun getHeroList(): List<HeroModel> {
        val localData = localDataSource.getHeroList()

        if(localData.isNotEmpty()){
            return localData.map { it.toHeroModel() }
        }else{
            val remoteData = remoteDataSource.getHeroList().filter {
                it.id?.isNotEmpty() == true
            }
            localDataSource.insertHeroList(remoteData.map { it.toHeroLocal() })
            return remoteData.map {
                it.toHeroModel()
            }
        }
    }

    override suspend fun getHeroById(id: String): HeroModel = localDataSource.getHeroById(id).toHeroModel()

    override suspend fun setFavorite(hero: HeroModel)  = localDataSource.setFavorite(hero.toHeroLocal())
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getLocationList(id: String): List<LocationModel> =
        remoteDataSource.getLocationList(id).map { it.toLocationModel() }


}