package com.example.marvelcharacters.di

import com.example.marvelcharacters.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        CharacterViewModel()
    }

}