package com.example.marvelcharacters.ui

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelcharacters.app.App
import com.example.marvelcharacters.R
import com.example.marvelcharacters.model.response.Success
import com.example.marvelcharacters.networking.NetworkStatusChecker
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.*
import androidx.work.*
import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.utils.toast
import com.example.marvelcharacters.viewmodel.CharacterViewModel
import com.example.marvelcharacters.worker.RemoteApiWorker
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }
    private val characterAdapter by lazy { CharacterGridAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCharacterGrid()
        viewModel.getAllCharacters().observe(this, Observer {
            characterAdapter.updateCharacters(it)
            if (characterAdapter.itemCount == 0) {
                getCharactersFromApi()
            }
        })
    }

    private fun getCharactersFromApi() {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiredNetworkType(NetworkType.NOT_ROAMING)
            .setRequiresBatteryNotLow(true)
            .setRequiresStorageNotLow(true)
            .build()

        val remoteApiWorker = OneTimeWorkRequestBuilder<RemoteApiWorker>()
            .setConstraints(constraints)
            .build()

        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(remoteApiWorker)

        workManager.getWorkInfoByIdLiveData(remoteApiWorker.id).observe(this, Observer { info ->
            if (info?.state?.isFinished == true) {
               if (info?.state == WorkInfo.State.FAILED) {
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
