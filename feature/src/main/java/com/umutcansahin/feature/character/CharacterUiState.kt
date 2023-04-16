package com.umutcansahin.feature.character

import androidx.paging.PagingData

sealed interface CharacterUiState {
    object Loading : CharacterUiState
    data class Success(val data: PagingData<CharacterResultUiModel>) : CharacterUiState
    data class Error(val message: String?) : CharacterUiState
}