package com.example.marvelcharacters.di

import com.example.marvelcharacters.view.CharacterGridAdapter
import org.koin.dsl.module

val mainViewModule = module {

    // CharacterGridAdapter
    single {
        CharacterGridAdapter()
    }

}