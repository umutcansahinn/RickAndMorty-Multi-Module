package com.umutcansahin.feature.location_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.databinding.FragmentLocationDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationDetailFragment : Fragment() {
    private val binding by viewBinding(FragmentLocationDetailBinding::bind)
    private val viewModel by viewModels<LocationDetailViewModel>()
    private val args: LocationDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.singleLocation.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is LocationDetailUiState.Loading -> {}
                    is LocationDetailUiState.Error -> {}
                    is LocationDetailUiState.Success -> {
                        locationDetailFragmentUI(result = it.data)
                    }
                }
            }
        }
    }

    private fun initView() {
        val locationId = args.locationId
        viewModel.getLocationById(locationId = locationId)
    }

    private fun locationDetailFragmentUI(result: LocationDetailResultUiModel) {
        binding.apply {

        }
    }
}