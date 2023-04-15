package com.umutcansahin.feature.character_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
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
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun initView() {
        val characterId = args.characterId
        viewModel.getCharacterById(characterId = characterId)
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.singleCharacter.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is CharacterDetailUiState.Loading -> {}
                    is CharacterDetailUiState.Error -> {}
                    is CharacterDetailUiState.Success -> {
                        characterDetailFragmentUI(result = it.data)
                    }
                }
            }
        }
    }

    private fun characterDetailFragmentUI(result: CharacterDetailResultUiModel) {
        binding.apply {
            textViewId.text = result.id.toString()
            textViewName.text = result.name
        }
    }
}