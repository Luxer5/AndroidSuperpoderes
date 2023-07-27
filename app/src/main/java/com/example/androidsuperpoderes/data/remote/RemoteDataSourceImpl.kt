package com.example.androidsuperpoderes.data.remote

import IdDto
import com.example.androidsuperpoderes.data.dto.HeroDTO
import com.example.androidsuperpoderes.data.dto.SearchDto

class RemoteDataSourceImpl(
    private val superHeroApi: SuperHeroApi
): RemoteDataSource {
    override suspend fun getHeroList(): List<HeroDTO> = superHeroApi.getHeroList(SearchDto())
    override suspend fun getLocationList(id: String) = superHeroApi.getLocationList(IdDto(id))
}