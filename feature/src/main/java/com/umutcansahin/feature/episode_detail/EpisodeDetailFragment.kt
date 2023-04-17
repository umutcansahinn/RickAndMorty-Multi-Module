package com.umutcansahin.feature.episode_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.umutcansahin.common.gone
import com.umutcansahin.common.viewBinding
import com.umutcansahin.common.visible
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentEpisodeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeDetailFragment : Fragment(R.layout.fragment_episode_detail) {
    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    private val viewModel by viewModels<EpisodeDetailViewModel>()
    private val args: EpisodeDetailFragmentArgs by navArgs()
    private val episodeDetailAdapter = EpisodeDetailAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {
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

    private fun initView() {
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
        val characterGroupId = characters.map {
            it.drop(42)
        }.toString()
        viewModel.getCharacterByGroupId(characterGroupId = characterGroupId)
    }
}