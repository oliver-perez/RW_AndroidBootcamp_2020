package com.example.marvelcharacters.view.characterdetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelcharacters.R
import com.example.marvelcharacters.model.entities.Character

fun Context.CharacterDetailActivityIntent(character: Character): Intent {
    return Intent(this, CharacterDetailActivity::class.java).apply {
        putExtra(INTENT_CHARACTER, character.name)
    }
}

private const val INTENT_CHARACTER = "character_info"

class CharacterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val characterName = intent.getStringExtra(INTENT_CHARACTER)
        requireNotNull(characterName) { "no characterName provided in Intent extras" }
    }
}