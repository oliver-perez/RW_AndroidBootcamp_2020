package com.example.marvelcharacters.app

import android.app.Application
import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.work.WorkManager
import com.example.marvelcharacters.di.characterViewModelModule
import com.example.marvelcharacters.di.mainViewModule
import com.example.marvelcharacters.repository.remote.RemoteApi
import com.example.marvelcharacters.repository.remote.buildApiService
import com.example.marvelcharacters.repository.local.CharacterDatabase
import com.example.marvelcharacters.repository.local.DATABASE_NAME
import com.example.marvelcharacters.repository.remote.RemoteApiWorker
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

private const val TOKEN = "996293b9351a1fe234f30428a547e095"
private const val HASH = "7e9348b74d67977821cbcc0279d0e666"

class App : Application() {
    companion object {
        lateinit var instance: App
        lateinit var characterDb: CharacterDatabase
        private val apiService by lazy { buildApiService() }
        val remoteApi by lazy { RemoteApi(apiService) }
        fun getToken() = TOKEN
        fun getHash() = HASH
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(mainViewModule, characterViewModelModule))
        }

        instance = this
        initRoom()
    }

    private fun initRoom() {
        characterDb = databaseBuilder(this, CharacterDatabase::class.java,
            DATABASE_NAME
        ).build()
    }
}