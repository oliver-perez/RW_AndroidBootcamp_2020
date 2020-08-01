package com.example.marvelcharacters.model.entities

import com.example.marvelcharacters.model.entities.Character
import kotlinx.serialization.Serializable

@Serializable
data class CharactersResponseData (
    val offset: Long,
    val limit: Long,
    val total: Long,
    val count: Long,
    val results: List<Character>
)