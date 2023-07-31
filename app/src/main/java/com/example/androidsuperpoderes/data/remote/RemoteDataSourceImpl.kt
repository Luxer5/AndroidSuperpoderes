package com.example.androidsuperpoderes.data.remote

import IdDto
import com.example.androidsuperpoderes.data.dto.HeroDTO
import com.example.androidsuperpoderes.data.dto.SearchDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(
    private val superHeroApi: SuperHeroApi
): RemoteDataSource {
    override suspend fun getHeroList(): Flow<List<HeroDTO>> = flow { emit(superHeroApi.getHeroList(SearchDto()))}
    override suspend fun getLocationList(id: String) = superHeroApi.getLocationList(IdDto(id))
}