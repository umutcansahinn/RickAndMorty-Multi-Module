package com.umutcansahin.feature.location_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.common.loadImageCircle
import com.umutcansahin.feature.databinding.AdapterEpisodeDetailBinding


class LocationDetailAdapter : RecyclerView.Adapter<LocationDetailAdapter.ViewHolder>() {
    class ViewHolder(val binding: AdapterEpisodeDetailBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val characterImageList = arrayListOf<CharacterGroupResultUiModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<CharacterGroupResultUiModel>) {
        characterImageList.clear()
        characterImageList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterEpisodeDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = characterImageList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.imageViewCharacterImage.loadImageCircle(characterImageList[position].image)
    }
}