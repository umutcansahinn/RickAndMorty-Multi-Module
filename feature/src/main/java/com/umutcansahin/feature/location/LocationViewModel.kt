package com.umutcansahin.feature.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.umutcansahin.domain.use_case.GetAllLocationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel @Inject constructor(
    private val getAllLocationUseCase: GetAllLocationUseCase
) : ViewModel() {

    private val _allLocation =
        MutableStateFlow<PagingData<LocationResultUiModel>>(PagingData.empty())
    val allLocation = _allLocation.asStateFlow()

    init {
        getAllLocation()
    }

    private fun getAllLocation() {
        viewModelScope.launch {
            getAllLocationUseCase().cachedIn(viewModelScope).collect { pagingData ->
                pagingData.map { it.toLocationResultUiModel() }.also {
                    _allLocation.value = it
                }
            }
        }
    }
}