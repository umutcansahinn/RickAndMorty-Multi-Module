package com.umutcansahin.feature.character_detail_bottom_sheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.umutcansahin.common.gone
import com.umutcansahin.common.visible
import com.umutcansahin.feature.databinding.FragmentCharacterBottomSheetBinding
import com.umutcansahin.feature.util.collectFlow
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CharacterBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentCharacterBottomSheetBinding? = null
    val binding get() = _binding!!

    private val viewModel by viewModels<CharacterBottomSheetViewModel>()

    @Inject
    lateinit var characterBottomSheetNavigator: CharacterBottomSheetNavigator

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBottomSheetBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        initView()
    }


    private fun observeData() {
        this.collectFlow(viewModel.singleEpisode) {
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

    private fun initView() {
        val episodeId = characterBottomSheetNavigator.getArgs().episodeId
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
