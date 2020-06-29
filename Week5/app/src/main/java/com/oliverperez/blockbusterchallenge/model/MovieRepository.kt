package com.oliverperez.blockbusterchallenge.model

import androidx.lifecycle.LiveData
import com.oliverperez.blockbusterchallenge.model.Movie

interface MovieRepository {
    fun addMovie(movie: Movie)
    fun getAllMovies(): LiveData<List<Movie>>
}