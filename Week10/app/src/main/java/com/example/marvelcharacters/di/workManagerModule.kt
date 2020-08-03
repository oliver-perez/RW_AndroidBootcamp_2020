package com.example.marvelcharacters.di

import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.marvelcharacters.repository.remote.RemoteApiWorker
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val workManagerModule = module {

    // WorkManager
    single {
        WorkManager.getInstance(androidContext())
    }
}

