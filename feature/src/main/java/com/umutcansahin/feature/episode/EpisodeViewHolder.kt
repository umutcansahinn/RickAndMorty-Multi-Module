package com.umutcansahin.feature.episode

import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.feature.databinding.AdapterEpisodeBinding

class EpisodeViewHolder(
    private val binding: AdapterEpisodeBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(episode: EpisodeResultUiModel, itemClickListener: (Int) -> Unit) {
        binding.apply {
            textViewName.text = episode.name
            textViewEpisode.text = episode.episode
            root.setOnClickListener {
                itemClickListener.invoke(episode.id)
            }
        }
    }
}