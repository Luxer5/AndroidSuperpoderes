package com.example.androidsuperpoderes.presentation.list

import androidx.lifecycle.ViewModel
import com.example.androidsuperpoderes.domain.useCase.GetHeroListUseCase

class HeroListViewModel (private val getHeroListUseCase: GetHeroListUseCase) : ViewModel(){
    val testString = "Test"
}