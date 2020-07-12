package com.example.marvelcharacters.model.entities

import kotlinx.serialization.Serializable

@Serializable
data class Character (
    val id: Long,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)