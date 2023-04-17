package com.umutcansahin.feature.episode

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.map
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentEpisodeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EpisodeFragment : Fragment(R.layout.fragment_episode) {
    private val binding by viewBinding(FragmentEpisodeBinding::bind)
    private val viewModel by viewModels<EpisodeViewModel>()
    private val episodeAdapter = EpisodeAdapter(::itemSetClick)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allEpisode.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is EpisodeUiState.Loading -> {}
                    is EpisodeUiState.Error -> {}
                    is EpisodeUiState.Success -> {
                        episodeAdapter.submitData(it.data)
                    }
                }
            }
        }
    }

    private fun initView() {
        binding.apply {
            recyclerView.adapter = episodeAdapter
        }
    }

    private fun itemSetClick(episodeId: Int) {
        findNavController().navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(episodeId = episodeId)
        )
    }
}