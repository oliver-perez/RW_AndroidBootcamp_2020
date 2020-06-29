package com.oliverperez.blockbusterchallenge.DataManagers

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oliverperez.blockbusterchallenge.Models.Movie

@Database(entities = [(Movie::class)], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}