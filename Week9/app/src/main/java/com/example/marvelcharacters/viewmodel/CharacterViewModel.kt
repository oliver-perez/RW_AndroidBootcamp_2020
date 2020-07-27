package com.example.marvelcharacters.viewmodel

import androidx.lifecycle.*
import androidx.work.*
import com.example.marvelcharacters.R
import com.example.marvelcharacters.app.Injection
import com.example.marvelcharacters.repository.remote.API_RESPONSE_WORKER_KEY
import com.example.marvelcharacters.repository.remote.RemoteApiWorker
import java.util.concurrent.TimeUnit

class CharacterViewModel() : ViewModel() {

    private val repository = Injection.provideRepository()
    private val workManager = Injection.provideWorkManager()
    private val updateBatchCharactersStatusId = MutableLiveData<Int>()

    fun getAllCharacters() = repository.getAllCharacters()
    fun getUpdateBatchStatus() = updateBatchCharactersStatusId
    fun onViewCreated() = setPeriodicWorkerRequests()

    /**
     * Runs background API requests periodically to check for updated information
     * */
    private fun setPeriodicWorkerRequests() {
        val remoteApiWorker = PeriodicWorkRequestBuilder<RemoteApiWorker>(15, TimeUnit.MINUTES)
            .setConstraints(getWorkerConstraints())
            .build()
        workManager.enqueue(remoteApiWorker)
        workManager.getWorkInfoByIdLiveData(remoteApiWorker.id).observeForever(Observer { info ->
            if (info.state == WorkInfo.State.ENQUEUED) {
                updateBatchCharactersStatusId.postValue(R.string.sync_in_progress)
                if (!info.outputData.getBoolean(API_RESPONSE_WORKER_KEY, true)) {
                    updateBatchCharactersStatusId.postValue(R.string.error_message)
                }
            }
        })
    }

    private fun getWorkerConstraints() = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiredNetworkType(NetworkType.NOT_ROAMING)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()
}