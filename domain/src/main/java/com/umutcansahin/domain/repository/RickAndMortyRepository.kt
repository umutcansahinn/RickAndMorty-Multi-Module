package com.umutcansahin.domain.repository

import androidx.paging.PagingData
import com.umutcansahin.domain.model.*
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {

    fun getAllCharacter(): Flow<PagingData<CharacterResultDM>>
    fun getAllEpisode(): Flow<PagingData<EpisodeResultDM>>
    fun getAllLocation(): Flow<PagingData<LocationResultDM>>

    suspend fun getCharacterById(characterId: Int): CharacterResultDM
    suspend fun getCharacterByGroupId(characterGroupId: String): List<CharacterResultDM>
    suspend fun getEpisodeById(episodeId: Int): EpisodeResultDM
    suspend fun getLocationById(locationId: Int): LocationResultDM
}