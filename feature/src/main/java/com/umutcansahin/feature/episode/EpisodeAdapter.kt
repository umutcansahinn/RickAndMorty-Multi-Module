package com.umutcansahin.feature.episode

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.umutcansahin.feature.databinding.AdapterEpisodeBinding

class EpisodeAdapter(
    private val itemClickListener: ((Int) -> Unit)
) : PagingDataAdapter<EpisodeResultUiModel, EpisodeViewHolder>(DiffUtils) {

    object DiffUtils : DiffUtil.ItemCallback<EpisodeResultUiModel>() {
        override fun areItemsTheSame(
            oldItem: EpisodeResultUiModel,
            newItem: EpisodeResultUiModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EpisodeResultUiModel,
            newItem: EpisodeResultUiModel
        ): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val episode = getItem(position)
        episode?.let {
            holder.bind(episode = episode, itemClickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        return EpisodeViewHolder(
            AdapterEpisodeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}