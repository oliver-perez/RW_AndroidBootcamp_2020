package com.example.marvelcharacters.viewmodel

import androidx.lifecycle.ViewModel
import com.example.marvelcharacters.app.Injection
import com.example.marvelcharacters.model.entities.Character

class CharacterViewModel() : ViewModel() {

    private val repository = Injection.provideRepository()

    suspend fun insert(characters: List<Character>) {
        repository.insert(characters)
    }

    fun getAllCharacters() = repository.getAllCharacters()
}