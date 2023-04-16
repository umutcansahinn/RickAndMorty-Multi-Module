package com.umutcansahin.feature.character_detail


sealed interface CharacterDetailUiState {
    object Loading : CharacterDetailUiState
    data class Success(val data: CharacterDetailResultUiModel) : CharacterDetailUiState
    data class Error(val message: String?) : CharacterDetailUiState
}