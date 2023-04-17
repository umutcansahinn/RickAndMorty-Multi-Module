package com.umutcansahin.feature.character_detail_bottom_sheet

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.umutcansahin.common.gone
import com.umutcansahin.common.viewBinding
import com.umutcansahin.common.visible
import com.umutcansahin.feature.R
import com.umutcansahin.feature.databinding.FragmentCharacterBottomSheetBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterBottomSheetFragment :
    BottomSheetDialogFragment(R.layout.fragment_character_bottom_sheet) {
    private val binding by viewBinding(FragmentCharacterBottomSheetBinding::bind)
    private val viewModel by viewModels<CharacterBottomSheetViewModel>()
    private val args: CharacterBottomSheetFragmentArgs by navArgs()

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
                    is CharacterBottomSheetUiState.Loading -> {
                        binding.apply {
                            progressBar.visible()
                            textViewErrorMessage.gone()
                            uiLayout.gone()
                        }
                    }
                    is CharacterBottomSheetUiState.Error -> {
                        binding.apply {
                            progressBar.gone()
                            textViewErrorMessage.visible()
                            textViewErrorMessage.text = it.message
                            uiLayout.gone()
                        }
                    }
                    is CharacterBottomSheetUiState.Success -> {
                        binding.apply {
                            progressBar.gone()
                            textViewErrorMessage.gone()
                            uiLayout.visible()
                            characterBsFragmentUI(model = it.data)
                        }
                    }
                }
            }
        }
    }

    private fun initView() {
        val episodeId = args.episodeId
        viewModel.getEpisodeById(episodeId = episodeId)
    }

    private fun characterBsFragmentUI(model: CharacterBottomSheetUiModel) {
        binding.apply {
            textViewUrl.text = model.url.drop(32)
            textViewName.text = model.name
            textViewAirDate.text = model.airDate
            textViewEpisode.text = model.episode
            textViewCreated.text = model.created
        }
    }
}