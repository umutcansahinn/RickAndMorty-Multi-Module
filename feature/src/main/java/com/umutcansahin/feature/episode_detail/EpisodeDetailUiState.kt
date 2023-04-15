package com.umutcansahin.feature.episode_detail

import androidx.annotation.StringRes

sealed interface EpisodeDetailUiState {
    object Loading : EpisodeDetailUiState
    data class Success(val data: EpisodeDetailResultUiModel) : EpisodeDetailUiState
    data class Error(@StringRes val message: Int) : EpisodeDetailUiState
}