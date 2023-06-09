package com.umutcansahin.feature.location_detail

import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.umutcansahin.feature.base.BaseFragment
import com.umutcansahin.feature.databinding.FragmentLocationDetailBinding
import com.umutcansahin.feature.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LocationDetailFragment :
    BaseFragment<FragmentLocationDetailBinding>(FragmentLocationDetailBinding::inflate) {

    private val viewModel by viewModels<LocationDetailViewModel>()
    private val locationDetailAdapter = LocationDetailAdapter()

    @Inject
    lateinit var locationDetailNavigator: LocationDetailNavigator

    override fun observeData() {
        this.collectFlow(viewModel.singleLocation) {
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
        this.collectFlow(viewModel.groupCharacter) {
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

    override fun initView() {
        val locationId = locationDetailNavigator.getArgs().locationId
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