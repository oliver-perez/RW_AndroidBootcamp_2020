package com.example.marvelcharacters.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelcharacters.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import androidx.work.WorkInfo
import com.example.marvelcharacters.repository.remote.API_RESPONSE_WORKER_KEY
import com.example.marvelcharacters.utils.toast
import com.example.marvelcharacters.viewmodel.CharacterViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: CharacterViewModel by lazy {
        ViewModelProviders.of(this).get(CharacterViewModel::class.java)
    }

    private val characterAdapter by lazy { CharacterGridAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCharacterGrid()
        configureObservers()
        viewModel.onViewCreated()
    }

    private fun configureObservers() {
        viewModel.getAllCharacters().observe(this, Observer {
            characterAdapter.updateCharacters(it)
        })
        viewModel.getUpdateBatchStatus().observe(this, Observer { statusResourceId ->
            toast(getString(statusResourceId))
        })
    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}
