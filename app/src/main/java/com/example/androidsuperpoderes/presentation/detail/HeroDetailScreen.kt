package com.keepcoding.androidsuperpoderesprofe.presentation.detail

import ShowError
import ShowHero
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.androidsuperpoderes.presentation.detail.DetailViewModel
import com.example.androidsuperpoderes.presentation.detail.HeroDetailState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroDetailScreen(
    id: String,
    detailViewModel: DetailViewModel = koinViewModel()
) {

    val heroState = detailViewModel.heroFlow.collectAsStateWithLifecycle()
    val errorState =detailViewModel.error.observeAsState()

    detailViewModel.getData(id)

    if(errorState.value?.isNotEmpty() ==true){
        val error =errorState.value
        ShowError(error = error?: "")
    }


    when (heroState.value) {
        is HeroDetailState.Idlestate -> {}
        is HeroDetailState.Loading ->{
            //Composable de Loading
        }
        is HeroDetailState.Hero ->{
            ShowHero((heroState.value as HeroDetailState.Hero).hero, true)
        }
    }

    /*heroState.value?.let { hero ->
        ShowHero(hero = HeroDetailState.Hero(hero), descripVisibility = true)
    } ?: run {ShowError(error = "Unknown Error")}*/

    //Mostrar información
}