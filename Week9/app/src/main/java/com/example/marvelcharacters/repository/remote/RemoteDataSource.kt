package com.example.marvelcharacters.repository.remote

import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.model.entities.GetCharactersResponse
import retrofit2.http.*

interface RemoteDataSource {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String = App.getToken(),
        @Query("hash") hash: String = App.getHash(),
        @Query("ts") timeStamp: String = "1"
        ): GetCharactersResponse
}