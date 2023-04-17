package com.umutcansahin.feature.episode_detail


sealed interface EpisodeDetailUiState {
    object Loading : EpisodeDetailUiState
    data class Success(val data: EpisodeDetailResultUiModel) : EpisodeDetailUiState
    data class Error(val message: String?) : EpisodeDetailUiState
}

sealed interface CharacterGroupUiState {
    object Loading : CharacterGroupUiState
    data class Success(val data: List<CharacterGroupResultUiModel>): CharacterGroupUiState
    data class Error(val message: String?): CharacterGroupUiState
}