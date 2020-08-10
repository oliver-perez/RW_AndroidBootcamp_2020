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
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val myViewModel: CharacterViewModel by viewModel()

    private val characterAdapter: CharacterGridAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCharacterGrid()
        configureObservers()
        myViewModel.onViewCreated()
    }

    private fun configureObservers() {
        myViewModel.getAllCharacters().observe(this, Observer {
            characterAdapter.updateCharacters(it)
        })
        myViewModel.getUpdateBatchStatus().observe(this, Observer { statusResourceId ->
            toast(getString(statusResourceId))
        })
    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}
