package com.example.androidsuperpoderes.presentation.list

import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.presentation.detail.HeroDetailState

sealed class HeroListState {

    object Idlestate : HeroListState()
    object Loading: HeroListState()
    data class ListHero(val listHero: List<HeroModel>) : HeroListState()
}