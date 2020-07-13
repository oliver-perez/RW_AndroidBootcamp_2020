package com.oliverperez.blockbusterchallenge.app

import com.oliverperez.blockbusterchallenge.model.MovieRepository
import com.oliverperez.blockbusterchallenge.model.RoomRepository
import kotlinx.coroutines.CoroutineScope

object Injection {
    fun provideMovieRepository(scope: CoroutineScope): MovieRepository = RoomRepository(scope)
}