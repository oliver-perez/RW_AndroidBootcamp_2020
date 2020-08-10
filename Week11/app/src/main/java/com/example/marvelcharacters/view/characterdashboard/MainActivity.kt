package com.example.marvelcharacters.view.characterdashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelcharacters.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.*
import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.utils.toast
import com.example.marvelcharacters.view.characterdetail.characterDetailActivityIntent
import com.example.marvelcharacters.viewmodel.CharacterViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.util.Pair
import kotlinx.android.synthetic.main.character_view_holder.view.*

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
        characterAdapter.listener = { view, character ->
            showDetail(view, character)
        }
    }

    private fun showDetail(view: View, character: Character) {
        val characterName = view.titleTextView
        val characterPoster = view.characterImageView
        val posterPair = Pair.create(characterPoster as View, "tPoster")
        val namePair = Pair.create(characterName as View, "tName")
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, posterPair, namePair)
        startActivity(
            characterDetailActivityIntent(
                character.name,
                character.description,
                character.thumbnail
            ),
            options.toBundle()
        )
    }

    private fun initCharacterGrid() {
        charactersRecyclerView.layoutManager = GridLayoutManager(this, 2)
        charactersRecyclerView.adapter = characterAdapter
    }
}
