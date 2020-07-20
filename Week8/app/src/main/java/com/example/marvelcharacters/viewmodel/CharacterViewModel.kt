package com.example.marvelcharacters.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcharacters.app.Injection
import com.example.marvelcharacters.model.entities.Character
import kotlinx.coroutines.launch

class CharacterViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = Injection.provideRepository()

    suspend fun insert(characters: List<Character>) {
        repository.insert(characters)
    }

    fun getAllCharacters() = repository.getAllCharacters()
}