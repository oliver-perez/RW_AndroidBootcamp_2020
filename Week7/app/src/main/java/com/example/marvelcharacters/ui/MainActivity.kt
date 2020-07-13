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
import com.example.marvelcharacters.utils.toast
import com.example.marvelcharacters.viewmodel.CharacterViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }
    private val remoteApi = App.remoteApi
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
        networkStatusChecker.performIfConnectedToInternet {
            lifecycleScope.launch(Dispatchers.Main) {
                val result = remoteApi.getCharacters()
                if (result is Success) {
                    viewModel.insert(result.data)
                } else {
                    toast(
                        getString(R.string.error_message)
                    )
                }
            }
        }
    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}
