package com.umutcansahin.feature.location_detail

import androidx.annotation.StringRes

sealed interface LocationDetailUiState {
    object Loading : LocationDetailUiState
    data class Success(val data: LocationDetailResultUiModel) : LocationDetailUiState
    data class Error(@StringRes val message: Int) : LocationDetailUiState
}