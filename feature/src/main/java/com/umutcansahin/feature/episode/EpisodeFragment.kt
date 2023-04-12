package com.umutcansahin.feature.episode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.R
import com.umutcansahin.feature.character.CharacterFragmentDirections
import com.umutcansahin.feature.databinding.FragmentCharacterBinding
import com.umutcansahin.feature.databinding.FragmentEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EpisodeFragment: Fragment(R.layout.fragment_episode) {
    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            findNavController().navigate(EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(1))
        }
    }
}