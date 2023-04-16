package com.umutcansahin.feature.character_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.common.Resource
import com.umutcansahin.domain.use_case.GetCharacterByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase
) : ViewModel() {

    private val _singleCharacter =
        MutableStateFlow<CharacterDetailUiState>(CharacterDetailUiState.Loading)
    val singleCharacter get() = _singleCharacter.asStateFlow()
    fun getCharacterById(characterId: Int) {
        viewModelScope.launch {
            when (val result = getCharacterByIdUseCase(characterId)) {
                is Resource.Error -> {
                   _singleCharacter.value = CharacterDetailUiState.Error(result.errorMessage)
                }
                is Resource.Loading -> {
                   _singleCharacter.value = CharacterDetailUiState.Loading
                }
                is Resource.Success-> {
                   _singleCharacter.value = CharacterDetailUiState.Success(result.data.toMap())
                }
            }
        }
    }
}