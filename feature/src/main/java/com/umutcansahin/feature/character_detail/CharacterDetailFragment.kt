package com.umutcansahin.feature.character_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.umutcansahin.common.loadImage
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailFragment : Fragment(R.layout.fragment_character_detail) {
    private val binding by viewBinding(FragmentCharacterDetailBinding::bind)
    private val viewModel by viewModels<CharacterDetailViewModel>()
    private val args: CharacterDetailFragmentArgs by navArgs()
    private val characterDetailAdapter = CharacterDetailAdapter(::itemSetClick)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun initView() {
        val characterId = args.characterId
        viewModel.getCharacterById(characterId = characterId)
        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.recyclerView.adapter = characterDetailAdapter
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.singleCharacter.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is CharacterDetailUiState.Loading -> {
                        binding.apply {
                            progressBar.visibility = View.VISIBLE
                            textViewErrorMessage.visibility = View.GONE
                            uiLayout.visibility = View.GONE
                        }
                    }
                    is CharacterDetailUiState.Error -> {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            textViewErrorMessage.visibility = View.VISIBLE
                            textViewErrorMessage.text = it.message
                            uiLayout.visibility = View.GONE
                        }
                    }
                    is CharacterDetailUiState.Success -> {
                        binding.apply {
                            progressBar.visibility = View.GONE
                            textViewErrorMessage.visibility = View.GONE
                            uiLayout.visibility = View.VISIBLE
                            characterDetailFragmentUI(result = it.data)
                        }
                    }
                }
            }
        }
    }

    private fun characterDetailFragmentUI(result: CharacterDetailResultUiModel) {
        binding.apply {
            imageView.loadImage(result.image)
            textViewName.text = result.name
            textViewStatus.text = result.status
            textViewSpecies.text = result.species
            textViewGender.text = result.gender
            textViewOrigin.text = result.origin.name
            characterDetailAdapter.updateList(newList = result.episode)
        }
    }

    private fun itemSetClick(episodeId: Int) {
        findNavController().navigate(
            CharacterDetailFragmentDirections
                .actionCharacterDetailFragmentToCharacterBottomSheet(episodeId = episodeId)
        )
    }
}