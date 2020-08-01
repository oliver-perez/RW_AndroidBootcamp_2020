package com.example.marvelcharacters.repository.local

import androidx.lifecycle.LiveData
import com.example.marvelcharacters.app.Injection
import com.example.marvelcharacters.model.entities.Character

class RoomRepository:
    CharacterRepository {

    private val characterDao = Injection.provideCharacterDao()

    override suspend fun insert(characters: List<Character>) = characterDao.insert(characters)

    override fun getAllCharacters(): LiveData<List<Character>> = characterDao.getAllCharacters()

}