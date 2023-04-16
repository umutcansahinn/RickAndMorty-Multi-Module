package com.umutcansahin.feature.character_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.umutcansahin.feature.databinding.AdapterCharacterDetailBinding

class CharacterDetailAdapter(
    private val itemClickListener: ((Int) -> Unit)
) : RecyclerView.Adapter<CharacterDetailAdapter.ViewHolder>() {

    private val episodeList = arrayListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<String>) {
        episodeList.clear()
        episodeList.addAll(newList)
        notifyDataSetChanged()
    }

    class ViewHolder(
        val binding: AdapterCharacterDetailBinding
        ): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            AdapterCharacterDetailBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return episodeList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            textViewName.text = episodeList[position].drop(32)
            root.setOnClickListener {
                itemClickListener.invoke(episodeList[position].drop(40).toInt())
            }
         }
    }
}