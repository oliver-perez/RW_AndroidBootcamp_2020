package com.example.marvelcharacters.repository.remote

import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.repository.remote.helpers.Failure
import com.example.marvelcharacters.repository.remote.helpers.Result
import com.example.marvelcharacters.repository.remote.helpers.Success


const val BASE_URL = "https://gateway.marvel.com"

class RemoteApi(private val apiService: RemoteDataSource) {

    suspend fun getCharacters(): Result<List<Character>> = try {
        val response = apiService.getCharacters()
        Success(response.data.results)
    } catch (error: Throwable) {
        Failure(error)
    }

}