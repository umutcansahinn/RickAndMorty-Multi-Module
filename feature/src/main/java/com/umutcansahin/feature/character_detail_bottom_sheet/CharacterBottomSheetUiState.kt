package com.umutcansahin.feature.character_detail_bottom_sheet

sealed interface CharacterBottomSheetUiState {
    object Loading : CharacterBottomSheetUiState
    data class Success(val data: CharacterBottomSheetUiModel) : CharacterBottomSheetUiState
    data class Error(val message: String?) : CharacterBottomSheetUiState
}