package com.umutcansahin.feature.location_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.common.Resource
import com.umutcansahin.domain.use_case.GetCharacterByGroupIdUseCase
import com.umutcansahin.domain.use_case.GetLocationByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    private val getLocationByIdUseCase: GetLocationByIdUseCase,
    private val getCharacterByGroupIdUseCase: GetCharacterByGroupIdUseCase
) : ViewModel() {

    private val _singleLocation =
        MutableStateFlow<LocationDetailUiState>(LocationDetailUiState.Loading)
    val singleLocation = _singleLocation.asStateFlow()

    private val _groupCharacter =
        MutableStateFlow<CharacterGroupUiState>(CharacterGroupUiState.Loading)
    val groupCharacter = _groupCharacter.asStateFlow()

    fun getLocationById(locationId: Int) {
        viewModelScope.launch {
            getLocationByIdUseCase(locationId).collect {resource->
                when (resource) {
                    is Resource.Loading -> {
                        _singleLocation.value = LocationDetailUiState.Loading
                    }
                    is Resource.Error -> {
                        _singleLocation.value = LocationDetailUiState.Error(resource.errorMessage)
                    }
                    is Resource.Success -> {
                        _singleLocation.value =
                            LocationDetailUiState.Success(resource.data.toLocationDetailResultUiModel())
                    }
                }
            }
        }
    }

    fun getCharacterByGroupId(characterGroupId: String) {
        viewModelScope.launch {
            getCharacterByGroupIdUseCase(characterGroupId).collect { resource ->
                when (resource) {
                    is Resource.Loading -> {
                        _groupCharacter.value = CharacterGroupUiState.Loading
                    }
                    is Resource.Error -> {
                        _groupCharacter.value = CharacterGroupUiState.Error(resource.errorMessage)
                    }
                    is Resource.Success -> {
                        _groupCharacter.value =
                            CharacterGroupUiState.Success(resource.data.map { it.toCharacterGroupResultUiModel() })
                    }
                }
            }
        }
    }
}