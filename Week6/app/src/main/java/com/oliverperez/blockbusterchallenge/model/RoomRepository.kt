package com.oliverperez.blockbusterchallenge.model

import com.oliverperez.blockbusterchallenge.app.BlockbusterApplication
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RoomRepository(private val scope: CoroutineScope) : MovieRepository {

    private val movieDao: MovieDao = BlockbusterApplication.getDatabase(scope).movieDao()

    override fun clearAllMovies() {
        scope.launch {
            movieDao.nukeTable()
        }
    }

    override fun getAllMovies() = movieDao.getAllMovies()

}