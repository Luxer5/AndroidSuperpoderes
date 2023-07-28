package com.keepcoding.androidsuperpoderesprofe.presentation.detail

import ShowError
import ShowHero
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.presentation.detail.DetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroDetailScreen(
    id: String,
    detailViewModel: DetailViewModel = koinViewModel()
) {

    val heroState = detailViewModel.hero.observeAsState()
    val errorState =detailViewModel.error.observeAsState()

    detailViewModel.getData(id)

    if(errorState.value?.isNotEmpty() ==true){
        val error =errorState.value
        ShowError(error = error?: "")
    }


    heroState.value?.let {
        ShowHero(hero = it, descripVisibility = true)
    } ?: ShowError(error = "Unknown Error")

    //Mostrar información
}