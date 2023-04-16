package com.umutcansahin.feature.episode_detail

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
class EpisodeDetailViewModel @Inject constructor(
    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase
) : ViewModel() {

    private val _singleEpisode =
        MutableStateFlow<EpisodeDetailUiState>(EpisodeDetailUiState.Loading)
    val singleEpisode get() = _singleEpisode.asStateFlow()
    fun getEpisodeById(episodeId: Int) {
        viewModelScope.launch {
            when(val result = getEpisodeByIdUseCase(episodeId)) {
                is Resource.Loading-> {
                    _singleEpisode.value = EpisodeDetailUiState.Loading
                }
                is Resource.Error-> {
                    _singleEpisode.value = EpisodeDetailUiState.Error(result.errorMessage)
                }
                is Resource.Success-> {
                    _singleEpisode.value = EpisodeDetailUiState.Success(result.data.toMap())
                }
            }
        }
    }
}