package com.example.marvelcharacters.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.marvelcharacters.repository.local.DATABASE_NAME
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = DATABASE_NAME)
data class Character(
    @PrimaryKey val id: Long,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail
)