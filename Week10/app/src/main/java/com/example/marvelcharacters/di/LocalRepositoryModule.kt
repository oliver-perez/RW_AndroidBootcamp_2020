package com.example.marvelcharacters.di

import androidx.room.Room
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.repository.local.CharacterDatabase
import com.example.marvelcharacters.repository.local.DATABASE_NAME
import com.example.marvelcharacters.repository.local.RoomRepository
import org.koin.dsl.module

val localRepositoryModule = module {

    single {
        RoomRepository()
    }

    single {
        Room.databaseBuilder(
            App.instance.applicationContext, CharacterDatabase::class.java,
            DATABASE_NAME
        ).build().characterDao()
    }

}