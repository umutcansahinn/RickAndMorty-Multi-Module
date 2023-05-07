package com.umutcansahin.feature.location

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.paging.LoadState
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentLocationBinding
import com.umutcansahin.feature.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LocationFragment : BaseFragment<FragmentLocationBinding>(FragmentLocationBinding::inflate) {
    private val viewModel by viewModels<LocationViewModel>()
    private val locationAdapter = LocationAdapter(::itemSetClick)

    @Inject
    lateinit var locationNavigator: LocationNavigator

    override fun observeData() {
        this.collectFlow(viewModel.allLocation) {
            locationAdapter.submitData(it)
        }
    }

    override fun initView() {
        binding.recyclerView.adapter = locationAdapter
        locationAdapter.addLoadStateListener {
            binding.recyclerView.isVisible = it.refresh is LoadState.NotLoading
            binding.progressBar.isVisible = it.refresh is LoadState.Loading
            binding.buttonRetry.isVisible = it.refresh is LoadState.Error
        }
        binding.buttonRetry.setOnClickListener {
            locationAdapter.retry()
        }
    }

    private fun itemSetClick(locationId: Int) {
        locationNavigator.navigate(locationId)
    }
}