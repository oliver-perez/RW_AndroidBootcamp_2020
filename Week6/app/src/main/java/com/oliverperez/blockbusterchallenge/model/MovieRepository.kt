package com.oliverperez.blockbusterchallenge.model

import androidx.lifecycle.LiveData

interface MovieRepository {
    fun getAllMovies(): LiveData<List<Movie>>
    fun clearAllMovies()
}