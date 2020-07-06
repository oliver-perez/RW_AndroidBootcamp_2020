package com.oliverperez.blockbusterchallenge.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: List<Movie>)

    @Query("SELECT * FROM movie_table ORDER BY title ASC")
    fun getAllMovies(): LiveData<List<Movie>>

    @Query("DELETE FROM movie_table")
    suspend fun nukeTable()
}