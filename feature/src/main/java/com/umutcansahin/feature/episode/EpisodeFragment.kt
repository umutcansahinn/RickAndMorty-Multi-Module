package com.umutcansahin.feature.episode

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentEpisodeBinding
import com.umutcansahin.feature.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>(FragmentEpisodeBinding::inflate) {

    private val viewModel by viewModels<EpisodeViewModel>()
    private val episodeAdapter = EpisodeAdapter(::itemSetClick)

    @Inject
    lateinit var episodeNavigator: EpisodeNavigator

    override fun observeData() {
        this.collectFlow(viewModel.allEpisode) {
            episodeAdapter.submitData(it)
        }
    }

    override fun initView() {
        binding.recyclerView.adapter = episodeAdapter
        episodeAdapter.addLoadStateListener {
            binding.recyclerView.isVisible = it.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = it.refresh is LoadState.Loading
            binding.buttonRetry.isVisible = it.refresh is LoadState.Error
        }
        binding.buttonRetry.setOnClickListener {
            episodeAdapter.retry()
        }
    }

    private fun itemSetClick(episodeId: Int) {
        episodeNavigator.navigate(episodeId)
    }
}