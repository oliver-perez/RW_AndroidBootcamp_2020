package com.example.marvelcharacters.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.marvelcharacters.model.converters.Converter
import com.example.marvelcharacters.model.entities.Character

@Database(entities = [(Character::class)], version = 1)
@TypeConverters(Converter::class)
abstract class CharacterDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}

const val DATABASE_NAME = "character_table"