package com.umutcansahin.feature.episode_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.databinding.FragmentEpisodeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeDetailFragment : Fragment() {
    private val binding by viewBinding(FragmentEpisodeDetailBinding::bind)
    private val viewModel by viewModels<EpisodeDetailViewModel>()
    private val args: EpisodeDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.singleEpisode.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is EpisodeDetailUiState.Loading -> {}
                    is EpisodeDetailUiState.Error -> {}
                    is EpisodeDetailUiState.Success -> {
                        episodeDetailFragmentUI(result = it.data)
                    }
                }
            }
        }
    }

    private fun initView() {
        val episodeId = args.episodeId
        viewModel.getEpisodeById(episodeId = episodeId)
    }

    private fun episodeDetailFragmentUI(result: EpisodeDetailResultUiModel) {
        binding.apply {

        }
    }
}