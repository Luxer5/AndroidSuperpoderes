package com.example.androidsuperpoderes.di

import com.example.androidsuperpoderes.domain.useCase.GetDetailUseCase
import com.example.androidsuperpoderes.domain.useCase.GetDistanceFromHeroUseCase
import com.example.androidsuperpoderes.domain.useCase.GetHeroListUseCase
import com.example.androidsuperpoderes.domain.useCase.GetHeroLocationUseCase
import org.koin.dsl.module

val domainModule  = module {

    single { GetHeroListUseCase(get()) }

    single { GetDetailUseCase(get()) }

    single { GetHeroLocationUseCase(get()) }

    single{ GetDistanceFromHeroUseCase() }

}