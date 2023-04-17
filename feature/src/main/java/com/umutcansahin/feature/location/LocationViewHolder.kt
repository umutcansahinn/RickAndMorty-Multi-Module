package com.umutcansahin.feature.location

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.feature.databinding.AdapterLocationBinding

class LocationViewHolder(
    private val binding: AdapterLocationBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(location: LocationResultUiModel, itemClickListener: (Int) -> Unit) {
        binding.textViewLocationName.text = location.name
        binding.root.setOnClickListener {
            itemClickListener.invoke(location.id)
        }
    }
}