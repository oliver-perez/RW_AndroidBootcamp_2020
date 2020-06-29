package com.oliverperez.blockbusterchallenge.app

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.oliverperez.blockbusterchallenge.DataManagers.MoviesDatabase

class BlockbusterApplication : Application() {

    companion object {
        lateinit var database: MoviesDatabase
        private lateinit var instance: BlockbusterApplication
        fun getAppContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
        database = Room.databaseBuilder(this, MoviesDatabase::class.java, "movies_database").build()
    }

}