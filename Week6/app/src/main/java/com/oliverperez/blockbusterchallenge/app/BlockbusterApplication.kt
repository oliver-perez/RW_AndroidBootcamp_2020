package com.oliverperez.blockbusterchallenge.app

import android.app.Application
import android.content.Context
import com.oliverperez.blockbusterchallenge.model.MoviesDatabase
import kotlinx.coroutines.CoroutineScope

class BlockbusterApplication : Application() {

    companion object {
        private lateinit var instance: BlockbusterApplication
        fun getAppContext(): Context = instance.applicationContext
        fun getDatabase(scope: CoroutineScope) = MoviesDatabase.getDatabase(instance.applicationContext, scope)
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }
}