package com.example.marvelcharacters.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelcharacters.R
import com.example.marvelcharacters.model.entities.Character
import kotlinx.android.synthetic.main.character_view_holder.view.*

class CharacterGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(character: Character) {
        itemView.titleTextView.text = character.name
        Glide.with(itemView)
            .load(character.thumbnail.path + "." + character.thumbnail.extension)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(itemView.characterImageView)
    }
}