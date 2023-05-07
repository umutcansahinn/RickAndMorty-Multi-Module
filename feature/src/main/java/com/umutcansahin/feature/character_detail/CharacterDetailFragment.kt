package com.umutcansahin.feature.character_detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.umutcansahin.common.gone
import com.umutcansahin.common.loadImage
import com.umutcansahin.common.visible
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentCharacterDetailBinding
import com.umutcansahin.feature.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterDetailFragment :
    BaseFragment<FragmentCharacterDetailBinding>(FragmentCharacterDetailBinding::inflate) {

    private val viewModel by viewModels<CharacterDetailViewModel>()
    private val characterDetailAdapter = CharacterDetailAdapter(::itemSetClick)

    @Inject
    lateinit var characterDetailNavigator: CharacterDetailNavigator

    override fun initView() {
        val characterId = characterDetailNavigator.getArgs().characterId
        viewModel.getCharacterById(characterId = characterId)
        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.recyclerView.adapter = characterDetailAdapter
    }

    override fun observeData() {
        this.collectFlow(viewModel.singleCharacter) {
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
        characterDetailNavigator.navigate(episodeId)
    }
}