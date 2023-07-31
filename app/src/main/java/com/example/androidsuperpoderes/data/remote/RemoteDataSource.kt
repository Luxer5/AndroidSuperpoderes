package com.example.androidsuperpoderes.data.remote

import LocationDto
import com.example.androidsuperpoderes.data.dto.HeroDTO
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    suspend fun getHeroList(): Flow<List<HeroDTO>>

    suspend fun getLocationList(id: String): List<LocationDto>
}
