package com.example.marvelcharacters

import android.app.Application
import com.example.marvelcharacters.networking.RemoteApi
import com.example.marvelcharacters.networking.buildApiService

private const val TOKEN = "996293b9351a1fe234f30428a547e095"
private const val HASH = "7e9348b74d67977821cbcc0279d0e666"

class App : Application() {
    companion object {
        private lateinit var instance: App
        private val apiService by lazy { buildApiService() }
        val remoteApi by lazy { RemoteApi(apiService) }

        fun getToken() = TOKEN
        fun getHash() = HASH

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}