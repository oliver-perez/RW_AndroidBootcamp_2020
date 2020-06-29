package com.oliverperez.blockbusterchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.oliverperez.blockbusterchallenge.app.BlockbusterApplication
import com.oliverperez.blockbusterchallenge.app.Injection
import com.oliverperez.blockbusterchallenge.model.Movie

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Injection.provideMovieRepository()
    private val allMovies = repository.getAllMovies()

    fun getAllMovies() = allMovies
    fun insert(movie: Movie) = repository.addMovie(movie)
    fun clearAllMovies() = repository.clearAllMovies()
}