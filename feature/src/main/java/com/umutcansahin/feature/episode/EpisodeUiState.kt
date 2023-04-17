package com.umutcansahin.feature.episode

import androidx.paging.PagingData

sealed interface EpisodeUiState {
    object Loading : EpisodeUiState
    data class Success(val data: PagingData<EpisodeResultUiModel>) : EpisodeUiState
    data class Error(val message: String?) : EpisodeUiState
}