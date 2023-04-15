package com.umutcansahin.feature.character

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.feature.databinding.AdapterCharacterBinding

class CharacterViewHolder(
    private val binding: AdapterCharacterBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterResultUiModel, itemClickListener: (Int) -> Unit) {
        binding.characterName.text = character.name
        binding.root.setOnClickListener {
            itemClickListener.invoke(character.id)
        }
    }
}