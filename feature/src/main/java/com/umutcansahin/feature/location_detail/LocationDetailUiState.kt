package com.umutcansahin.feature.location_detail


sealed interface LocationDetailUiState {
    object Loading : LocationDetailUiState
    data class Success(val data: LocationDetailResultUiModel) : LocationDetailUiState
    data class Error( val message: String?) : LocationDetailUiState
}