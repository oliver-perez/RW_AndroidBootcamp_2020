package com.oliverperez.blockbusterchallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.oliverperez.blockbusterchallenge.app.Injection
import com.oliverperez.blockbusterchallenge.model.Movie

class MoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = Injection.provideMovieRepository(viewModelScope)

    fun getAllMovies(): LiveData<List<Movie>> {
        return repository.getAllMovies()
    }
}