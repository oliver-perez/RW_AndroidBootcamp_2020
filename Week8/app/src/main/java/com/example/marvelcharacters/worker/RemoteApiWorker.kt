package com.example.marvelcharacters.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.app.Injection
import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.model.response.Success

class RemoteApiWorker(context: Context, workerParameters: WorkerParameters) : CoroutineWorker(context, workerParameters) {
    private val remoteApi = App.remoteApi
    private val repository = Injection.provideRepository()

    override suspend fun doWork(): Result {
        val result = remoteApi.getCharacters()
        return if (result is Success) {
            repository.insert(result.data)
            Result.success()
        } else {
            Result.failure()
        }
    }
}