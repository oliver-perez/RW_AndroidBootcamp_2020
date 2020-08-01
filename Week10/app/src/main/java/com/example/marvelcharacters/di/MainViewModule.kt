package com.example.marvelcharacters.di

import com.example.marvelcharacters.repository.local.RoomRepository
import com.example.marvelcharacters.view.CharacterGridAdapter
import com.example.marvelcharacters.viewmodel.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainViewModule = module {

    viewModel {
        CharacterViewModel()
    }

    single {
        CharacterGridAdapter()
    }

}