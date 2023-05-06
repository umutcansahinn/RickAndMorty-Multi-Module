package com.umutcansahin.feature.episode_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.umutcansahin.common.Resource
import com.umutcansahin.domain.use_case.GetCharacterByGroupIdUseCase
import com.umutcansahin.domain.use_case.GetEpisodeByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodeDetailViewModel @Inject constructor(
    private val getEpisodeByIdUseCase: GetEpisodeByIdUseCase,
    private val getCharacterByGroupIdUseCase: GetCharacterByGroupIdUseCase
) : ViewModel() {

    private val _singleEpisode =
        MutableStateFlow<EpisodeDetailUiState>(EpisodeDetailUiState.Loading)
    val singleEpisode = _singleEpisode.asStateFlow()

    private val _groupCharacter =
        MutableStateFlow<CharacterGroupUiState>(CharacterGroupUiState.Loading)
    val groupCharacter = _groupCharacter.asStateFlow()

    fun getEpisodeById(episodeId: Int) {
        viewModelScope.launch {
            getEpisodeByIdUseCase(episodeId).collect {
                when (it) {
                    is Resource.Loading -> {
                        _singleEpisode.value = EpisodeDetailUiState.Loading
                    }
                    is Resource.Error -> {
                        _singleEpisode.value = EpisodeDetailUiState.Error(it.errorMessage)
                    }
                    is Resource.Success -> {
                        _singleEpisode.value =
                            EpisodeDetailUiState.Success(it.data.toEpisodeDetailResultUiModel())
                    }
                }
            }
        }
    }


    fun getCharacterByGroupId(characters: List<String>) {
        val characterGroupId = characters.map {
            it.drop(42)
        }.toString()
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