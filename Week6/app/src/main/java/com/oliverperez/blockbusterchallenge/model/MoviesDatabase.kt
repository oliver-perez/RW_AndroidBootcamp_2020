package com.oliverperez.blockbusterchallenge.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [(Movie::class)], version = 1)
abstract class MoviesDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    /**
    *  Intercept the database as it’s being opened or created to insert the data while the database is being created.
    **/
    private class MoviesDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { dataBase ->
                scope.launch {
                    populateMovieDataBase(dataBase.movieDao())
                }
            }
        }

        private suspend fun populateMovieDataBase(movieDao: MovieDao) {
            movieDao.insert(DummyDataProvider().getMovies())
        }
    }

    companion object {

        @Volatile
        private var INSTANCE: MoviesDatabase? = null

        fun getDatabase(context: Context, coroutineScope: CoroutineScope): MoviesDatabase {
            val tempInstance =
                INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this@Companion) {
                val instance = Room.databaseBuilder(context.applicationContext,
                    MoviesDatabase::class.java,
                    "movie_table")
                    .addCallback(MoviesDatabaseCallback(coroutineScope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}