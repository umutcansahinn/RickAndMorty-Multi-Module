package com.umutcansahin.feature.location

import androidx.annotation.StringRes
import androidx.paging.PagingData

sealed interface LocationUiState {
    object Loading : LocationUiState
    data class Success(val data: PagingData<LocationResultUiModel>) : LocationUiState
    data class Error(@StringRes val message: Int) : LocationUiState
}