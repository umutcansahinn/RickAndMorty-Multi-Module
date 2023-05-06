package com.umutcansahin.feature.episode_detail

import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.umutcansahin.common.gone
import com.umutcansahin.common.visible
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentEpisodeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeDetailFragment :
    BaseFragment<FragmentEpisodeDetailBinding>(FragmentEpisodeDetailBinding::inflate) {

    private val viewModel by viewModels<EpisodeDetailViewModel>()
    private val args: EpisodeDetailFragmentArgs by navArgs()
    private val episodeDetailAdapter = EpisodeDetailAdapter()

    override fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.singleEpisode.collect {
                        when (it) {
                            is EpisodeDetailUiState.Loading -> {
                                binding.apply {
                                    progressBar.visible()
                                    textViewErrorMessage.gone()
                                    uiLayout.gone()
                                }
                            }
                            is EpisodeDetailUiState.Error -> {
                                binding.apply {
                                    progressBar.gone()
                                    textViewErrorMessage.visible()
                                    textViewErrorMessage.text = it.message
                                    uiLayout.gone()
                                }
                            }
                            is EpisodeDetailUiState.Success -> {
                                binding.apply {
                                    progressBar.gone()
                                    textViewErrorMessage.gone()
                                    uiLayout.visible()
                                    episodeDetailFragmentUI(result = it.data)
                                    setCharacterGroupId(characters = it.data.characters)
                                }
                            }
                        }
                    }
                }
                launch {
                    viewModel.groupCharacter.collect {
                        when (it) {
                            is CharacterGroupUiState.Loading -> {
                                binding.apply {
                                    progressBarRecyclerView.visible()
                                    textViewErrorMessageRecyclerView.gone()
                                    recyclerView.gone()
                                }
                            }
                            is CharacterGroupUiState.Error -> {
                                binding.apply {
                                    progressBarRecyclerView.gone()
                                    textViewErrorMessageRecyclerView.visible()
                                    textViewErrorMessageRecyclerView.text = it.message
                                    recyclerView.gone()
                                }
                            }
                            is CharacterGroupUiState.Success -> {
                                binding.apply {
                                    progressBarRecyclerView.gone()
                                    textViewErrorMessageRecyclerView.gone()
                                    recyclerView.visible()
                                    episodeDetailAdapter.updateList(it.data)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun initView() {
        val episodeId = args.episodeId
        viewModel.getEpisodeById(episodeId = episodeId)

        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.recyclerView.adapter = episodeDetailAdapter
    }

    private fun episodeDetailFragmentUI(result: EpisodeDetailResultUiModel) {
        binding.apply {
            textViewNameUrl.text = result.url.drop(32)
            textViewName.text = result.name
            textViewAirDate.text = result.airDate
            textViewEpisode.text = result.episode
        }
    }

    private fun setCharacterGroupId(characters: List<String>) {
        viewModel.getCharacterByGroupId(characters = characters)
    }
}