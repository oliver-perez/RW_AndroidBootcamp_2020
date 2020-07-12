package com.example.marvelcharacters.model.response
import com.example.marvelcharacters.model.entities.CharactersResponseData
import kotlinx.serialization.Serializable

@Serializable
data class GetCharactersResponse (
    val data: CharactersResponseData
)