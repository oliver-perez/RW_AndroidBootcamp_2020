package com.example.marvelcharacters.di

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.repository.remote.*
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val remoteRepositoryModule = module {

    single {
        Constraints.Builder()
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
        WorkManager.getInstance(App.instance.applicationContext)
    }

    single {
        RemoteApi(get())
    }

    // Build retrofit
    single {
        val contentType = "application/json".toMediaType()
        Retrofit.Builder()
            .client(get())
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.nonstrict.asConverterFactory(contentType))
            .build()
            .create(RemoteDataSource::class.java)
    }

    // Build OkHttpClient
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

}