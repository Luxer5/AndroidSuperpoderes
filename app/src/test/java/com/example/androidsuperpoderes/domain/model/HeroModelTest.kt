package com.example.androidsuperpoderes.domain.model

import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class HeroModelTest{
    val heroModel = HeroModel("56", "Alex", "foto" ,"descripcion", false)

    @Test
    fun `WHEN  heromodel id is "56" EXPECT id = "56"`(){
        assertThat(heroModel.id,  `is` ("56"))
    }
    @Test
    fun `WHEN  heromodel name is "Alex" EXPECT name = "Alex"`(){
        assertThat(heroModel.name,  `is` ("Alex"))
    }
    @Test
    fun `WHEN  heromodel photoUrl is "foto" EXPECT photoUrl = "foto"`(){
        assertThat(heroModel.photoUrl,  `is` ("foto"))
    }
    @Test
    fun `WHEN  heromodel description is "descripcion" EXPECT description = "descripcon"`(){
        assertThat(heroModel.description,  `is` ("descripcion"))
    }
    @Test
    fun `WHEN  heromodel favorite is false EXPECT favorite = false`(){
        assertThat(heroModel.favorite,  `is` (false))
    }
    @Test
    fun `WHEN create model EXPECT not null vlue`(){
        assertThat(heroModel,  instanceOf(HeroModel::class.java) )
        assertThat(heroModel,  notNullValue() )
    }
}