package com.example.marvelcharacters.viewmodel

import androidx.lifecycle.*
import androidx.work.*
import com.example.marvelcharacters.R
import com.example.marvelcharacters.repository.local.CharacterRepository
import com.example.marvelcharacters.repository.local.RoomRepository
import com.example.marvelcharacters.repository.remote.API_RESPONSE_WORKER_KEY
import org.koin.core.KoinComponent
import org.koin.core.inject

class CharacterViewModel() : ViewModel(), KoinComponent {
    private val repository: CharacterRepository by inject<RoomRepository>()
    private val workManager: WorkManager by inject()
    private val periodicApiWorker: PeriodicWorkRequest by inject()
    private val updateBatchCharactersStatusId = MutableLiveData<Int>()

    fun getAllCharacters() = repository.getAllCharacters()
    fun getUpdateBatchStatus() = updateBatchCharactersStatusId
    fun onViewCreated() = setPeriodicWorkerRequests()

    /**
     * Runs background API requests periodically to check for updated information
     * */
    private fun setPeriodicWorkerRequests() {
        workManager.enqueue(periodicApiWorker)
        workManager.getWorkInfoByIdLiveData(periodicApiWorker.id).observeForever(Observer {
            postBatchCharactersStatusWhenEnqueued(it)
        })
    }

    private fun postBatchCharactersStatusWhenEnqueued(info: WorkInfo) {
        if (info.state == WorkInfo.State.ENQUEUED) {
            updateBatchCharactersStatusId.postValue(R.string.sync_in_progress)
            if (!info.outputData.getBoolean(API_RESPONSE_WORKER_KEY, true)) {
                updateBatchCharactersStatusId.postValue(R.string.error_message)
            }
        }
    }
}