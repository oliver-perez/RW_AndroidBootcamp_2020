package com.example.marvelcharacters.app

import com.example.marvelcharacters.repository.CharacterRepository
import com.example.marvelcharacters.repository.RoomRepository

object Injection {
    fun provideRepository(): CharacterRepository = RoomRepository()
}