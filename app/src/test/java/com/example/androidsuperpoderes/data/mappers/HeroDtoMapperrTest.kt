package com.example.androidsuperpoderes.data.mappers

import com.example.androidsuperpoderes.data.dto.HeroDTO
import org.hamcrest.CoreMatchers
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import toHeroModel

class HeroDtoMapperrTest{

    @Test
    fun  `WHEN toHeroModel with values EXPECT model has value`(){
        val heroDto = HeroDTO(
            id = "test-id",
            photo =  "photo-url",
            name = "sample name",
            description = "descripcion",
            favorite = false
            )

        val res = heroDto.toHeroModel()
        assertThat(res.id, `is`("test-id"))
    }
    @Test
    fun  `WHEN toHeroModel with null EXPECT empty String`(){
        val heroDto = HeroDTO(
            id = null,
            photo =  null,
            name = null,
            description = null,
            favorite = false
            )

        val res = heroDto.toHeroModel()
        assertThat(res.id, `is`(""))
    }
}