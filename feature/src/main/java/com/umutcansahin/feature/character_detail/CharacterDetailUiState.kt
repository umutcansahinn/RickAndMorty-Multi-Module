package com.umutcansahin.feature.character_detail

import androidx.annotation.StringRes

sealed interface CharacterDetailUiState {
    object Loading: CharacterDetailUiState
    data class Success(val data: CharacterDetailResultUiModel): CharacterDetailUiState
    data class Error(@StringRes val message: Int): CharacterDetailUiState
}