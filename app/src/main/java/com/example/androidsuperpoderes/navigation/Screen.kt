package com.example.androidsuperpoderes.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
){
    object LoginScreen: Screen(
        route = "login",
        arguments = emptyList()
    )

    object ForgotPassWordScreen : Screen(
        route = "forgotPassword",
        arguments = emptyList()
    )

    object  HeroListScreen : Screen(
        route = "heroList",
        arguments = emptyList()
    )
}