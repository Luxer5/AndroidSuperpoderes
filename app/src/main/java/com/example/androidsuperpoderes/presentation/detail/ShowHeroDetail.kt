package com.example.androidsuperpoderes.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.androidsuperpoderes.R
import com.example.androidsuperpoderes.componentes.StartComponent
import com.example.androidsuperpoderes.domain.TestDataBuilder
import com.example.androidsuperpoderes.domain.model.HeroModel
import kotlinx.coroutines.job

//Ejercicio ostrar un Diseño de un Hero

@Composable
fun ShowHeroDetail(
    hero: HeroModel,
    descripVisibility: Boolean = false
) {
    var starred by remember {
        mutableStateOf(false)
    }


    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()

    ) {
        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            placeholder = painterResource(id = R.drawable.ball),
            error = painterResource(id = R.drawable.ball),
            model = ImageRequest.Builder(LocalContext.current)
                .data(hero.photoUrl)
                .build(),
            contentDescription = "Imagen de ${hero.name}"
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = hero.name, maxLines = 1, overflow = TextOverflow.Ellipsis)
                if (descripVisibility) {
                    Text(text = hero.description, maxLines = 4, overflow = TextOverflow.Ellipsis)
                }

            }
            //Cambiar estrella por checkbox

            Checkbox(
                modifier = Modifier
                    .clearAndSetSemantics {
                    //.semantics {
                    contentDescription = "Hacer ${hero.name} Favorito"
                    stateDescription = if (starred) {
                        "${hero.name} marcado como favorito"
                    } else {
                        "${hero.name} desmarcado como favorito"
                    }
                },
                checked = starred,
                onCheckedChange = {
                    starred =it
                }
            )
        }
    }
    // Gestionar la semántica y los cambios de estado


    /*
    Ejecuta el requestFocus al finalizar la composición de la vista
     */
}

@Composable
fun AndroidViewTest(hero: HeroModel) {
    var starred by remember {
        mutableStateOf(false)
    }
    // Star
    AndroidView(
        modifier = Modifier
            .semantics {
                contentDescription = "Hacer ${hero.name} Favorito"
                stateDescription = if (starred) {
                    "${hero.name} marked as Favorite"
                } else {
                    "${hero.name} marked as not Favorite"
                }
            }
            .clickable {
                val newState = !starred
                starred = newState
            },
        factory = { context ->
            StartComponent(context).apply {
                this.checked = starred
            }
        },
        update = {
            it.checked = starred
        }
    )
}


@Preview
@Composable
fun ShowHeroPreview() {
    ShowHeroDetail(TestDataBuilder().buildSingle())
}