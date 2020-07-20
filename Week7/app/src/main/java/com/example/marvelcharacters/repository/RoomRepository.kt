package com.example.marvelcharacters.repository

import androidx.lifecycle.LiveData
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.model.entities.Character

class RoomRepository: CharacterRepository {

    private val characterDao = App.characterDb.characterDao()

    override suspend fun insert(characters: List<Character>) = characterDao.insert(characters)

    override fun getAllCharacters(): LiveData<List<Character>> = characterDao.getAllCharacters()

}