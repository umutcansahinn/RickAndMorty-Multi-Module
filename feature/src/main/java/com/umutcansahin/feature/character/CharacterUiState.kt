package com.umutcansahin.feature.character

import androidx.annotation.StringRes
import androidx.paging.PagingData

sealed interface CharacterUiState {
    object Loading : CharacterUiState
    data class Success(val data: PagingData<CharacterResultUiModel>) : CharacterUiState
    data class Error(@StringRes val message: Int) : CharacterUiState
}