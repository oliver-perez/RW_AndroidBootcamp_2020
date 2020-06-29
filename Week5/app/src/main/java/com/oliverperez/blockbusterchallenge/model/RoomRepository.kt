package com.oliverperez.blockbusterchallenge.model

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.oliverperez.blockbusterchallenge.app.BlockbusterApplication

class RoomRepository :
    MovieRepository {

    private val movieDao: MovieDao = BlockbusterApplication.database.movieDao()
    private val allMovies: LiveData<List<Movie>>

    init {
        allMovies = movieDao.getAllMovies()
    }

    override fun addMovie(movie: Movie) {
        InsertAsyncTask(
            movieDao
        ).execute((movie))
    }

    override fun clearAllMovies() {
        DeleteAsyncTask(movieDao).execute()
    }

    override fun getAllMovies() = allMovies

    private class InsertAsyncTask internal constructor(private val dao: MovieDao) : AsyncTask<Movie, Void, Void>() {
        override fun doInBackground(vararg params: Movie): Void? {
            dao.insert(params[0])
            return null
        }
    }

    private class DeleteAsyncTask internal constructor(private val dao: MovieDao) : AsyncTask<Movie, Void, Void>() {
        override fun doInBackground(vararg params: Movie): Void? {
            dao.nukeTable()
            return null
        }
    }
}