package com.oliverperez.blockbusterchallenge.app

import com.oliverperez.blockbusterchallenge.model.MovieRepository
import com.oliverperez.blockbusterchallenge.model.RoomRepository

object Injection {
    fun provideMovieRepository(): MovieRepository =
        RoomRepository()
}