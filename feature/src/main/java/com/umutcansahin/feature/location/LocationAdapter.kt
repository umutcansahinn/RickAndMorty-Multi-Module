package com.umutcansahin.feature.location

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.umutcansahin.feature.databinding.AdapterLocationBinding

class LocationAdapter(
    private val itemClickListener: ((Int) -> Unit)
) : PagingDataAdapter<LocationResultUiModel, LocationViewHolder>(DiffUtils) {

    object DiffUtils : DiffUtil.ItemCallback<LocationResultUiModel>() {
        override fun areItemsTheSame(
            oldItem: LocationResultUiModel,
            newItem: LocationResultUiModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: LocationResultUiModel,
            newItem: LocationResultUiModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val location = getItem(position)
        location?.let {
            holder.bind(location = location, itemClickListener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            AdapterLocationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
}