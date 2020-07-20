package com.example.marvelcharacters.model.entities

import androidx.room.TypeConverter
import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail (
    val path: String,
    val extension: String
)
