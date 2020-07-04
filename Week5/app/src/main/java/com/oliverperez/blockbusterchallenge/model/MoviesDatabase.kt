package com.oliverperez.blockbusterchallenge.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oliverperez.blockbusterchallenge.model.Movie
import com.oliverperez.blockbusterchallenge.model.MovieDao

@Database(entities = [(Movie::class)], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}