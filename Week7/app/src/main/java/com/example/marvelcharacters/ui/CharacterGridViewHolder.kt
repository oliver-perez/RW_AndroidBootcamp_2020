package com.example.marvelcharacters.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.model.entities.Character
import kotlinx.android.synthetic.main.character_view_holder.view.*

class CharacterGridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(character: Character) {
        itemView.titleTextView.text = character.name
    }
}