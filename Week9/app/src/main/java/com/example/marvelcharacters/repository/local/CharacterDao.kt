package com.example.marvelcharacters.repository.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvelcharacters.model.entities.Character

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(characters: List<Character>)

    @Query("SELECT * FROM character_table ORDER BY name ASC")
    fun getAllCharacters(): LiveData<List<Character>>
}