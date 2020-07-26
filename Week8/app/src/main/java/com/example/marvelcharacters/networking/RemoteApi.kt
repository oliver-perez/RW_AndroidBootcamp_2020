package com.example.marvelcharacters.networking

import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.model.response.*


const val BASE_URL = "https://gateway.marvel.com"

class RemoteApi(private val apiService: RemoteApiService) {

    suspend fun getCharacters(): Result<List<Character>> = try {
        val response = apiService.getCharacters()
        Success(response.data.results)
    } catch (error: Throwable) {
        Failure(error)
    }

}