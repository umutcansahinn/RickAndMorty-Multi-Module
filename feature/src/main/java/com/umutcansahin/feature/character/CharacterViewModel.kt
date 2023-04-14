package com.umutcansahin.feature.character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.umutcansahin.domain.use_case.GetAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getAllCharacterUseCase: GetAllCharacterUseCase
) : ViewModel() {

    private val _allCharacter = MutableStateFlow<CharacterUiState>(CharacterUiState.Loading)
    val allCharacter get() = _allCharacter.asStateFlow()

    init {
        getAllCharacter()
    }

    private fun getAllCharacter() {
        viewModelScope.launch {
            getAllCharacterUseCase().cachedIn(viewModelScope).collect { pagingData ->
                pagingData.map { it.toMap() }.also {
                    _allCharacter.value = CharacterUiState.Success(it)
                }
            }
        }
    }
}