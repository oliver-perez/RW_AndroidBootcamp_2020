package com.oliverperez.blockbusterchallenge.DataManagers

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.oliverperez.blockbusterchallenge.Models.Movie

@Dao
interface MovieDao {
    @Insert
    fun insert(movie: Movie)

    @Query("SELECT * FROM movie_table ORDER BY title ASC")
    fun getAllMovies(): LiveData<List<Movie>>
}