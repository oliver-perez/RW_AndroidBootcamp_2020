package com.oliverperez.blockbusterchallenge.DataManagers

import androidx.lifecycle.LiveData
import com.oliverperez.blockbusterchallenge.Models.Movie

interface MovieRepository {
    fun addMovie(movie: Movie)
    fun getAllMovies(): LiveData<List<Movie>>
}