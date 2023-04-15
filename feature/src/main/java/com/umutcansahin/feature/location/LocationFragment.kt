package com.umutcansahin.feature.location

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.umutcansahin.common.viewBinding
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationFragment : Fragment(R.layout.fragment_location) {
    private val binding by viewBinding(FragmentLocationBinding::bind)
    private val viewModel by viewModels<LocationViewModel>()
    private val locationAdapter = LocationAdapter(::itemSetClick)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        observeData()
    }

    private fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.allLocation.flowWithLifecycle(
                viewLifecycleOwner.lifecycle,
                Lifecycle.State.STARTED
            ).collect {
                when (it) {
                    is LocationUiState.Loading -> {}
                    is LocationUiState.Error -> {}
                    is LocationUiState.Success -> {
                        locationAdapter.submitData(it.data)
                    }
                }
            }
        }
    }

    private fun initView() {
        binding.apply {
            recyclerView.adapter = locationAdapter
        }
    }

    private fun itemSetClick(locationId: Int) {
        findNavController().navigate(
            LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(locationId = locationId)
        )
    }

}