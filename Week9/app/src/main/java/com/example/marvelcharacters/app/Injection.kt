package com.example.marvelcharacters.app

import com.example.marvelcharacters.networking.RemoteApi
import com.example.marvelcharacters.repository.CharacterDao
import com.example.marvelcharacters.repository.CharacterRepository
import com.example.marvelcharacters.repository.RoomRepository

object Injection {
    fun provideRepository(): CharacterRepository = RoomRepository()
    fun provideRemoteApi(): RemoteApi = App.remoteApi
    fun provideCharacterDao(): CharacterDao = App.characterDb.characterDao()
}