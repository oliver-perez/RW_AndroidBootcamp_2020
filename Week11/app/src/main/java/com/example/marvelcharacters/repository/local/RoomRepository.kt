package com.example.marvelcharacters.repository.local

import androidx.lifecycle.LiveData
import com.example.marvelcharacters.model.entities.Character
import org.koin.core.KoinComponent
import org.koin.core.inject

class RoomRepository:
    CharacterRepository, KoinComponent {

    private val characterDao: CharacterDao by inject()

    override suspend fun insert(characters: List<Character>) = characterDao.insert(characters)

    override fun getAllCharacters(): LiveData<List<Character>> = characterDao.getAllCharacters()

}