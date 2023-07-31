package com.example.androidsuperpoderes.presentation.detail

import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.domain.model.HeroModel

sealed class HeroDetailState {
    object Idlestate : HeroDetailState()
    object Loading: HeroDetailState()
    data class Hero(val hero: HeroModel) : HeroDetailState()
}

val testObject = HeroDetailState.Idlestate
val testDataClass = HeroDetailState.Hero(TestDataBuilder().buildSingle())