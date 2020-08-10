package com.example.marvelcharacters.repository.remote

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.marvelcharacters.repository.local.CharacterRepository
import com.example.marvelcharacters.repository.local.RoomRepository
import com.example.marvelcharacters.repository.remote.helpers.Success
import org.koin.core.KoinComponent
import org.koin.core.inject

const val API_RESPONSE_WORKER_KEY = "api_response_success"

class RemoteApiWorker(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters), KoinComponent {
    private val remoteApi: RemoteApi by inject()
    private val repository: CharacterRepository by inject<RoomRepository>()

    override suspend fun doWork(): Result {
        val result = remoteApi.getCharacters()
        return if (result is Success) {
            repository.insert(result.data)
            Result.success(workDataOf(API_RESPONSE_WORKER_KEY to true))
        } else {
            Result.failure(workDataOf(API_RESPONSE_WORKER_KEY to false))
        }
    }
}