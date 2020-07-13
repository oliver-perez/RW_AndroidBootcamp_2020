package com.example.marvelcharacters.app

import android.app.Application
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import com.example.marvelcharacters.networking.RemoteApi
import com.example.marvelcharacters.networking.buildApiService
import com.example.marvelcharacters.repository.CharacterDatabase
import com.example.marvelcharacters.repository.DATABASE_NAME

private const val TOKEN = "996293b9351a1fe234f30428a547e095"
private const val HASH = "7e9348b74d67977821cbcc0279d0e666"

class App : Application() {
    companion object {
        private lateinit var instance: App
        lateinit var characterDb: CharacterDatabase
        private val apiService by lazy { buildApiService() }
        val remoteApi by lazy { RemoteApi(apiService) }

        fun getToken() = TOKEN
        fun getHash() = HASH
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initRoom()
    }

    private fun initRoom() {
        characterDb = databaseBuilder(this, CharacterDatabase::class.java, DATABASE_NAME).build()
    }
}