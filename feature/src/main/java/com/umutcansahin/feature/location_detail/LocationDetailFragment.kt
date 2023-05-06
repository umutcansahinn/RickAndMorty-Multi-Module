package com.umutcansahin.feature.location_detail

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentLocationDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LocationDetailFragment :
    BaseFragment<FragmentLocationDetailBinding>(FragmentLocationDetailBinding::inflate) {

    private val viewModel by viewModels<LocationDetailViewModel>()
    private val args: LocationDetailFragmentArgs by navArgs()
    private val locationDetailAdapter = LocationDetailAdapter()

    override fun observeData() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    viewModel.singleLocation.collect {
                        when (it) {
                            is LocationDetailUiState.Loading -> {
                                binding.apply {
                                    progressBar.visibility = View.VISIBLE
                                    textViewErrorMessage.visibility = View.GONE
                                    uiLayout.visibility = View.GONE
                                }
                            }
                            is LocationDetailUiState.Error -> {
                                binding.apply {
                                    progressBar.visibility = View.GONE
                                    textViewErrorMessage.visibility = View.VISIBLE
                                    textViewErrorMessage.text = it.message
                                    uiLayout.visibility = View.GONE
                                }
                            }
                            is LocationDetailUiState.Success -> {
                                binding.apply {
                                    progressBar.visibility = View.GONE
                                    textViewErrorMessage.visibility = View.GONE
                                    uiLayout.visibility = View.VISIBLE
                                    locationDetailFragmentUI(result = it.data)
                                    setCharacterGroupId(characters = it.data.residents)
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
                                    progressBarRecyclerView.visibility = View.VISIBLE
                                    textViewErrorMessageRecyclerView.visibility = View.GONE
                                    recyclerView.visibility = View.GONE
                                }
                            }
                            is CharacterGroupUiState.Error -> {
                                binding.apply {
                                    progressBarRecyclerView.visibility = View.GONE
                                    textViewErrorMessageRecyclerView.visibility = View.VISIBLE
                                    textViewErrorMessageRecyclerView.text = it.message
                                    recyclerView.visibility = View.GONE
                                }
                            }
                            is CharacterGroupUiState.Success -> {
                                binding.apply {
                                    progressBarRecyclerView.visibility = View.GONE
                                    textViewErrorMessageRecyclerView.visibility = View.GONE
                                    recyclerView.visibility = View.VISIBLE
                                    locationDetailAdapter.updateList(it.data)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun initView() {
        val locationId = args.locationId
        viewModel.getLocationById(locationId = locationId)

        binding.imageBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
        binding.recyclerView.adapter = locationDetailAdapter
    }

    private fun locationDetailFragmentUI(result: LocationDetailResultUiModel) {
        binding.apply {
            textViewNameUrl.text = result.url.drop(32)
            textViewName.text = result.name
            textViewType.text = result.type
            textViewDimension.text = result.dimension

        }
    }

    private fun setCharacterGroupId(characters: List<String>) {
        viewModel.getCharacterByGroupId(characters = characters)
    }
}