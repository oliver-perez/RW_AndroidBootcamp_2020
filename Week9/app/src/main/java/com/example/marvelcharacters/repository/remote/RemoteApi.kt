package com.example.marvelcharacters.repository.remote

import com.example.marvelcharacters.model.entities.Character


const val BASE_URL = "https://gateway.marvel.com"

class RemoteApi(private val apiService: RemoteDataSource) {

    suspend fun getCharacters(): Result<List<Character>> = try {
        val response = apiService.getCharacters()
        Success(response.data.results)
    } catch (error: Throwable) {
        Failure(error)
    }

}