package com.umutcansahin.feature.location_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.domain.use_case.GetLocationByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LocationDetailViewModel @Inject constructor(
    private val getLocationByIdUseCase: GetLocationByIdUseCase
): ViewModel(){

    private val _singleLocation = MutableStateFlow<LocationDetailUiState>(LocationDetailUiState.Loading)
    val singleLocation get() = _singleLocation.asStateFlow()
    fun getLocationById(locationId: Int) {
        viewModelScope.launch {
            _singleLocation.value = LocationDetailUiState.Success(
                getLocationByIdUseCase(locationId).toMap()
            )
        }
    }
}