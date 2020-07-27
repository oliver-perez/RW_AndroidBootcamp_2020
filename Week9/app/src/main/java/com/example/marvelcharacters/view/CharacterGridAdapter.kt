package com.example.marvelcharacters.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcharacters.R
import com.example.marvelcharacters.model.entities.Character

class CharacterGridAdapter(): RecyclerView.Adapter<CharacterGridViewHolder>() {

    private var characters: MutableList<Character> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterGridViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.character_view_holder, parent, false)
        return CharacterGridViewHolder(view)
    }

    fun updateCharacters(characters: List<Character>) {
        this.characters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterGridViewHolder, position: Int) {
        holder.bind(characters[position])
    }
}