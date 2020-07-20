package com.example.marvelcharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelcharacters.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import androidx.work.*
import com.example.marvelcharacters.utils.toast
import com.example.marvelcharacters.viewmodel.CharacterViewModel
import com.example.marvelcharacters.worker.API_RESPONSE_WORKER_KEY
import com.example.marvelcharacters.worker.RemoteApiWorker
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    private val viewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

    private val characterAdapter by lazy { CharacterGridAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCharacterGrid()
        viewModel.getAllCharacters().observe(this, Observer {
            characterAdapter.updateCharacters(it)
        })
        updateBatchCharactersFromApi()
    }

    /**
     * Runs background API requests periodically to check for updated information
     * */
    private fun updateBatchCharactersFromApi() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiredNetworkType(NetworkType.NOT_ROAMING)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()

        val remoteApiWorker = PeriodicWorkRequestBuilder<RemoteApiWorker>(15, TimeUnit.SECONDS)
            .setConstraints(constraints)
            .build()

        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(remoteApiWorker)

        workManager.getWorkInfoByIdLiveData(remoteApiWorker.id).observe(this, Observer { info ->
            if ((info != null) && (info.state == WorkInfo.State.ENQUEUED)) {
               if (!info?.outputData.getBoolean(API_RESPONSE_WORKER_KEY, true)) {
                   toast(getString(R.string.error_message))
               }
            }
        })
    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}
