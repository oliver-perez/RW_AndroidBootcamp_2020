package com.oliverperez.blockbusterchallenge.app

import com.oliverperez.blockbusterchallenge.DataManagers.MovieRepository
import com.oliverperez.blockbusterchallenge.DataManagers.RoomRepository

object Injection {
    fun provideMovieRepository(): MovieRepository = RoomRepository()
}