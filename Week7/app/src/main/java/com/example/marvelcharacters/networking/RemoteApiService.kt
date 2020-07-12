package com.example.marvelcharacters.networking

import com.example.marvelcharacters.model.response.GetCharactersResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val PUBLIC_KEY = "996293b9351a1fe234f30428a547e095"
private const val TIME_STAMP = "1"
private const val HASH = "7e9348b74d67977821cbcc0279d0e666"

interface RemoteApiService {
    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") timeStamp: String = TIME_STAMP,
        @Query("apiKey") apiKey: String = PUBLIC_KEY,
        @Query("hash") hash: String = HASH
    ): GetCharactersResponse
}