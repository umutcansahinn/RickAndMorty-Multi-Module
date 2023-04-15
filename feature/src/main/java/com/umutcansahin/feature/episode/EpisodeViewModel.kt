package com.umutcansahin.feature.episode

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import androidx.paging.map
import com.umutcansahin.domain.use_case.GetAllEpisodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeViewModel @Inject constructor(
    private val getAllEpisodeUseCase: GetAllEpisodeUseCase
) : ViewModel() {

    private val _allEpisode = MutableStateFlow<EpisodeUiState>(EpisodeUiState.Loading)
    val allEpisode get() = _allEpisode.asStateFlow()

    init {
        getAllEpisode()
    }

    private fun getAllEpisode() {
        viewModelScope.launch {
            getAllEpisodeUseCase().cachedIn(viewModelScope).collect { pagingData ->
                pagingData.map { it.toMap() }.also {
                    _allEpisode.value = EpisodeUiState.Success(it)
                }
            }
        }
    }
}