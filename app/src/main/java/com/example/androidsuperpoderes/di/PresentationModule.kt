package com.example.androidsuperpoderes.di

import com.example.androidsuperpoderes.presentation.detail.DetailViewModel
import com.example.androidsuperpoderes.presentation.list.HeroListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel{ HeroListViewModel(get())}

    viewModel{ DetailViewModel(get(), get(), get(), get())}
}