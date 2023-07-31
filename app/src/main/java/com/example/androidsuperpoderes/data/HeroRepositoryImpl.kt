package com.example.androidsuperpoderes.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.androidsuperpoderes.data.local.LocalDataSource
import com.example.androidsuperpoderes.data.remote.RemoteDataSource
import com.example.androidsuperpoderes.domain.model.HeroIdModel
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.domain.model.LocationModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import toHeroLocal
import toHeroModel
import toLocationModel

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): HeroRepository {

    override suspend fun getHeroList(): Flow<List<HeroModel>> = remoteDataSource.getHeroList().map { list->
            list.map {
                it.toHeroModel() }
        }



    override suspend fun getHeroById(id: String): Flow<HeroModel> = localDataSource
        .getHeroById(id).map {  it.toHeroModel()}

    override suspend fun setFavorite(hero: HeroModel)  = localDataSource.setFavorite(hero.toHeroLocal())
    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getLocationList(id: String): List<LocationModel> =
        remoteDataSource.getLocationList(id).map { it.toLocationModel() }


}