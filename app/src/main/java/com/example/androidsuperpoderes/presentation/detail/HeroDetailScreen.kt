@file:OptIn(ExperimentalMaterial3Api::class)

package com.keepcoding.androidsuperpoderesprofe.presentation.detail

import ShowError
import android.annotation.SuppressLint
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.androidsuperpoderes.presentation.detail.DetailViewModel
import com.example.androidsuperpoderes.presentation.detail.ShowHeroDetail
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HeroDetailScreen(
    id: String,
    detailViewModel: DetailViewModel = koinViewModel(),
    onBackPressed : () -> Unit
) {

    val heroState = detailViewModel.hero.observeAsState()
    val errorState =detailViewModel.error.observeAsState()

    detailViewModel.getData(id)

    if(errorState.value?.isNotEmpty() ==true){
        val error =errorState.value
        ShowError(error = error?: "")
    }


    heroState.value?.let {hero ->
        Scaffold (
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Detalle del ${hero.name}")
                    },
                    navigationIcon = {
                        IconButton(
                            modifier= Modifier.semantics {
                                contentDescription= "Atras, Boton Ir al listado de personajes"
                            },
                            onClick = onBackPressed
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                        Icons.Filled.ArrowBack
                    }
                )
            }
        )
         {
            ShowHeroDetail(hero = hero, descripVisibility = true)
        }

    } ?: ShowError(error = "Unknown Error")

    //Mostrar información
}