package com.umutcansahin.feature.episode

import androidx.annotation.StringRes
import androidx.paging.PagingData

sealed interface EpisodeUiState {
    object Loading: EpisodeUiState
    data class Success(val data: PagingData<EpisodeResultUiModel>): EpisodeUiState
    data class Error(@StringRes val message: Int): EpisodeUiState
}