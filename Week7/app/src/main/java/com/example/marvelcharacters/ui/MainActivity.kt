package com.example.marvelcharacters.ui

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelcharacters.App
import com.example.marvelcharacters.R
import com.example.marvelcharacters.model.response.Success
import com.example.marvelcharacters.networking.NetworkStatusChecker
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val remoteApi = App.remoteApi
    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }
    private val characterAdapter by lazy { CharacterGridAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCharacterGrid()
        networkStatusChecker.performIfConnectedToInternet {
            GlobalScope.launch(Dispatchers.Main) {
                val result = remoteApi.getCharacters()
                if (result is Success) {
                    characterAdapter.updateCharacters(result.data as MutableList)
                } else {
                    // TODO: Implement error handling
                }
            }
        }

    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}