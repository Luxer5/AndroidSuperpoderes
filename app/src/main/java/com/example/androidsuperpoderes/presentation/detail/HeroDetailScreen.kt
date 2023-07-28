package com.keepcoding.androidsuperpoderesprofe.presentation.detail

import ShowHero
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.domain.model.HeroModel
import com.example.androidsuperpoderes.presentation.detail.DetailViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HeroDetailScreen(
    id: String,
    detailViewModel: DetailViewModel = koinViewModel()
) {

    val state = detailViewModel.hero.observeAsState()
    detailViewModel.getData(id)
    ShowHero(
        hero = state.value?: HeroModel("id","nombre", "", "descvripcion", false)
    )

    //Mostrar información
}