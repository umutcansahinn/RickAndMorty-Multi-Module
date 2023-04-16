package com.umutcansahin.feature.location_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.common.Resource
import com.umutcansahin.domain.use_case.GetLocationByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    private val getLocationByIdUseCase: GetLocationByIdUseCase
) : ViewModel() {

    private val _singleLocation =
        MutableStateFlow<LocationDetailUiState>(LocationDetailUiState.Loading)
    val singleLocation get() = _singleLocation.asStateFlow()
    fun getLocationById(locationId: Int) {
        viewModelScope.launch {
            when(val result = getLocationByIdUseCase(locationId)) {
                is Resource.Loading-> {
                    _singleLocation.value = LocationDetailUiState.Loading
                }
                is Resource.Error-> {
                    _singleLocation.value = LocationDetailUiState.Error(result.errorMessage)
                }
                is Resource.Success-> {
                    _singleLocation.value = LocationDetailUiState.Success(result.data.toMap())
                }
            }
        }
    }
}