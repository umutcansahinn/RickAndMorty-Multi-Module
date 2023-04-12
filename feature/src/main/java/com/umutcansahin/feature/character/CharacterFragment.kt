package com.umutcansahin.feature.character

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterFragment : Fragment(R.layout.fragment_character) {
   private val binding by viewBinding(FragmentCharacterBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.root.setOnClickListener {
            findNavController().navigate(CharacterFragmentDirections.actionCharacterFragmentToCharacterDetailFragment(1))
        }
    }
}