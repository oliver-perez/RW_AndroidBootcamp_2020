package com.example.marvelcharacters.networking

import com.example.marvelcharacters.App
import com.example.marvelcharacters.model.response.GetCharactersResponse
import retrofit2.http.*

interface RemoteApiService {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("apikey") apiKey: String = App.getToken(),
        @Query("hash") hash: String = App.getHash(),
        @Query("ts") timeStamp: String = "1"
        ): GetCharactersResponse
}