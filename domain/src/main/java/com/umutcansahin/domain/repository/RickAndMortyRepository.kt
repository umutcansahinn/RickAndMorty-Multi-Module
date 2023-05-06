package com.umutcansahin.domain.repository

import androidx.paging.PagingData
import com.umutcansahin.domain.model.*
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {

    fun getAllCharacter(): Flow<PagingData<CharacterResultDomainModel>>
    fun getAllEpisode(): Flow<PagingData<EpisodeResultDomainModel>>
    fun getAllLocation(): Flow<PagingData<LocationResultDomainModel>>

    suspend fun getCharacterById(characterId: Int): CharacterResultDomainModel
    suspend fun getCharacterByGroupId(characterGroupId: String): List<CharacterResultDomainModel>
    suspend fun getEpisodeById(episodeId: Int): EpisodeResultDomainModel
    suspend fun getLocationById(locationId: Int): LocationResultDomainModel
}