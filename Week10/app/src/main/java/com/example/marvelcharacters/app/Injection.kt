package com.example.marvelcharacters.app

import androidx.work.WorkManager
import com.example.marvelcharacters.repository.remote.RemoteApi
import com.example.marvelcharacters.repository.local.CharacterDao
import com.example.marvelcharacters.repository.local.CharacterRepository
import com.example.marvelcharacters.repository.local.RoomRepository

object Injection {
    fun provideRepository(): CharacterRepository =
        RoomRepository()
    fun provideRemoteApi(): RemoteApi = App.remoteApi
    fun provideCharacterDao(): CharacterDao = App.characterDb.characterDao()
    fun provideWorkManager(): WorkManager = App.workManager
}