package com.example.marvelcharacters.app

import android.app.Application
import com.example.marvelcharacters.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

private const val TOKEN = "996293b9351a1fe234f30428a547e095"
private const val HASH = "7e9348b74d67977821cbcc0279d0e666"

class App : Application() {
    companion object {
        lateinit var instance: App
        fun getToken() = TOKEN
        fun getHash() = HASH
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                listOf(
                    mainViewModule,
                    viewModelModule,
                    localRepositoryModule,
                    remoteRepositoryModule,
                    workManagerModule
                )
            )
        }
        instance = this
    }

}