package com.example.androidsuperpoderes.data.remote

import LocationDto
import com.example.androidsuperpoderes.data.dto.HeroDTO

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDTO>

    suspend fun getLocationList(id: String): List<LocationDto>
}
