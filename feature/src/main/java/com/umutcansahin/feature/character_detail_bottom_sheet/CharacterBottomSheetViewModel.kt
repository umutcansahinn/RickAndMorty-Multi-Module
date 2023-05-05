package com.umutcansahin.feature.character_detail_bottom_sheet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.common.Resource
import com.umutcansahin.domain.use_case.GetEpisodeByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterBottomSheetViewModel @Inject constructor(
    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase
): ViewModel() {

    private val _singleEpisode =
        MutableStateFlow<CharacterBottomSheetUiState>(CharacterBottomSheetUiState.Loading)
    val singleEpisode = _singleEpisode.asStateFlow()

    fun getEpisodeById(episodeId: Int) {
        viewModelScope.launch {
            getEpisodeByIdUseCase(episodeId).collect {
                when(it) {
                    is Resource.Loading-> {
                        _singleEpisode.value = CharacterBottomSheetUiState.Loading
                    }
                    is Resource.Error-> {
                        _singleEpisode.value = CharacterBottomSheetUiState.Error(it.errorMessage)
                    }
                    is Resource.Success-> {
                        _singleEpisode.value = CharacterBottomSheetUiState.Success(it.data.toMap())
                    }
                }
            }
        }
    }
}