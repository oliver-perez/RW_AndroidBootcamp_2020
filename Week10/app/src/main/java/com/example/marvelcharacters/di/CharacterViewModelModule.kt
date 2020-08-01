package com.example.marvelcharacters.di

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.repository.local.RoomRepository
import com.example.marvelcharacters.repository.remote.RemoteApiWorker
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val characterViewModelModule = module {
    single { Constraints.Builder()
        .setRequiredNetworkType(NetworkType.NOT_ROAMING)
        .setRequiresBatteryNotLow(true)
        .setRequiresStorageNotLow(true)
        .build()
    }

    single {
        PeriodicWorkRequestBuilder<RemoteApiWorker>(15, TimeUnit.MINUTES)
            .setConstraints(get())
            .build()
    }

    single {
        RoomRepository()
    }

    single {
        WorkManager.getInstance(App.instance.applicationContext)
    }
}