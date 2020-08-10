package com.example.marvelcharacters.view.characterdashboard

import android.content.ClipData.newIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelcharacters.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.utils.toast
import com.example.marvelcharacters.view.characterdashboard.CharacterGridAdapter
import com.example.marvelcharacters.view.characterdetail.CharacterDetailActivity
import com.example.marvelcharacters.view.characterdetail.CharacterDetailActivityIntent
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
        characterAdapter.listener = {
            showDetail(it)
        }
    }

    private fun showDetail(character: Character) {
        startActivity(CharacterDetailActivityIntent(character))
    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}
