package com.example.marvelcharacters.di

import androidx.room.Room
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.repository.local.CharacterDatabase
import com.example.marvelcharacters.repository.local.DATABASE_NAME
import com.example.marvelcharacters.repository.local.RoomRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val localRepositoryModule = module {

    // Room Repository
    single {
        RoomRepository()
    }

    // Character DAO
    single {
        Room.databaseBuilder(
            androidContext(),
            CharacterDatabase::class.java,
            DATABASE_NAME
        )
            .build()
            .characterDao()
    }

}