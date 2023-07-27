package com.keepcoding.androidsuperpoderesprofe.presentation.detail

import ShowHero
import androidx.compose.runtime.Composable
import com.example.androidsuperpoderes.domain.TestDataBuilder

@Composable
fun HeroDetailScreen(
    id: String
) {
    ShowHero(
        hero = TestDataBuilder()
            .withName("Id: $id")
            .withDescription("fghjfghjghj fghjkghjfghj ghjghjkfghjk fghjghjghj")
            .buildSingle())

    //Mostrar información
}