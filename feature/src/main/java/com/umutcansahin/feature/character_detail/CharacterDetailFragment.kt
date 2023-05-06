package com.umutcansahin.feature.character_detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.umutcansahin.common.gone
import com.umutcansahin.common.loadImage
import com.umutcansahin.common.visible
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentCharacterDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding>(FragmentCharacterDetailBinding::inflate) {

    private val viewModel by viewModels<CharacterDetailViewModel>()
    private val args: CharacterDetailFragmentArgs by navArgs()
    private val characterDetailAdapter = CharacterDetailAdapter(::itemSetClick)

    override fun initView() {
        val characterId = args.characterId
        viewModel.getCharacterById(characterId = characterId)
        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.recyclerView.adapter = characterDetailAdapter
    }

    override fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.singleCharacter.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is CharacterDetailUiState.Loading -> {
                        binding.apply {
                            progressBar.visible()
                            textViewErrorMessage.gone()
                            uiLayout.gone()
                        }
                    }
                    is CharacterDetailUiState.Error -> {
                        binding.apply {
                            progressBar.gone()
                            textViewErrorMessage.visible()
                            textViewErrorMessage.text = it.message
                            uiLayout.gone()
                        }
                    }
                    is CharacterDetailUiState.Success -> {
                        binding.apply {
                            progressBar.gone()
                            textViewErrorMessage.gone()
                            uiLayout.visible()
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