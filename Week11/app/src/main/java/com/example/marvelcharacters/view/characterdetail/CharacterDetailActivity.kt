package com.example.marvelcharacters.view.characterdetail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.marvelcharacters.R
import com.example.marvelcharacters.model.entities.Character
import com.example.marvelcharacters.model.entities.Thumbnail
import kotlinx.android.synthetic.main.activity_character_detail.*
import kotlinx.android.synthetic.main.character_view_holder.view.*

fun Context.characterDetailActivityIntent(
    characterName: String,
    characterDescription: String,
    characterThumbnail: Thumbnail
): Intent {
    return Intent(this, CharacterDetailActivity::class.java).apply {
        putExtra(INTENT_CHARACTER_NAME, characterName)
        putExtra(INTENT_CHARACTER_DESCRIPTION, characterDescription)
        putExtra(INTENT_CHARACTER_THUMBNAIL, characterThumbnail)
    }
}

private const val INTENT_CHARACTER_NAME = "character_name"
private const val INTENT_CHARACTER_DESCRIPTION = "character_description"
private const val INTENT_CHARACTER_THUMBNAIL = "character_thumbnail"

class CharacterDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        val characterName = intent.getStringExtra(INTENT_CHARACTER_NAME)
        val characterDescription = intent.getStringExtra(INTENT_CHARACTER_DESCRIPTION)
        val characterThumbnail = intent.getParcelableExtra<Thumbnail>(INTENT_CHARACTER_THUMBNAIL)

        requireNotNull(characterName) { "no characterName provided in Intent extras" }
        detailTitle.text = characterName
        detailDescription.text = characterDescription

        characterThumbnail?.let { downloadPosterImage(it) }
    }

    private fun downloadPosterImage(thumbnail: Thumbnail) {
        Glide.with(this)
            .load(getUrlFormatted(thumbnail))
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(posterView)
    }

    private fun getUrlFormatted(thumbnail: Thumbnail): String = if (thumbnail.extension.isBlank()) {
        thumbnail.path
    } else {
        thumbnail.path + "." + thumbnail.extension
    }
}