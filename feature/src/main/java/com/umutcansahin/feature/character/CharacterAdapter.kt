package com.umutcansahin.feature.character

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.umutcansahin.feature.databinding.AdapterCharacterBinding

class CharacterAdapter(
    private val itemClickListener: ((Int) -> Unit)
) : PagingDataAdapter<CharacterResultUiModel, CharacterViewHolder>(DiffUtils) {

    object DiffUtils : DiffUtil.ItemCallback<CharacterResultUiModel>() {
        override fun areItemsTheSame(
            oldItem: CharacterResultUiModel,
            newItem: CharacterResultUiModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CharacterResultUiModel,
            newItem: CharacterResultUiModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = getItem(position)
        character?.let {
            holder.bind(character = it,itemClickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            AdapterCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}