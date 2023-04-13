package com.umutcansahin.data.source

import androidx.paging.PagingData
import com.umutcansahin.data.response.character.CharacterResult
import com.umutcansahin.data.response.episode.EpisodeResult
import com.umutcansahin.data.response.location.LocationResult
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    fun getAllCharacter(): Flow<PagingData<CharacterResult>>
    fun getAllEpisode(): Flow<PagingData<EpisodeResult>>
    fun getAllLocation(): Flow<PagingData<LocationResult>>

    suspend fun getCharacterById(characterId: Int): CharacterResult
    suspend fun getEpisodeById(episodeId: Int): EpisodeResult
    suspend fun getLocationById(locationId: Int): LocationResult
}