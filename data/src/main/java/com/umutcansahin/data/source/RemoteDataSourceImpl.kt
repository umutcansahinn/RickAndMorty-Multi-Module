package com.umutcansahin.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.umutcansahin.common.Constants
import com.umutcansahin.data.api.RickAndMortyApi
import com.umutcansahin.data.paging_source.CharacterPagingSource
import com.umutcansahin.data.paging_source.EpisodePagingSource
import com.umutcansahin.data.paging_source.LocationPagingSource
import com.umutcansahin.data.response.character.CharacterResult
import com.umutcansahin.data.response.episode.EpisodeResult
import com.umutcansahin.data.response.location.LocationResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi
): RemoteDataSource {

    override fun getAllCharacter(): Flow<PagingData<CharacterResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = {
                CharacterPagingSource(rickAndMortyApi = rickAndMortyApi)
            }
        ).flow
    }

    override fun getAllEpisode(): Flow<PagingData<EpisodeResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = {
                EpisodePagingSource(rickAndMortyApi = rickAndMortyApi)
            }
        ).flow
    }

    override fun getAllLocation(): Flow<PagingData<LocationResult>> {
        return Pager(
            config = PagingConfig(
                pageSize = Constants.NETWORK_PAGE_SIZE
            ),
            pagingSourceFactory = {
                LocationPagingSource(rickAndMortyApi = rickAndMortyApi)
            }
        ).flow
    }

    override suspend fun getCharacterById(characterId: Int): CharacterResult {
        return rickAndMortyApi.getCharacterById(characterId = characterId)
    }

    override suspend fun getEpisodeById(episodeId: Int): EpisodeResult {
        return rickAndMortyApi.getEpisodeById(episodeId = episodeId)
    }

    override suspend fun getLocationById(locationId: Int): LocationResult {
        return rickAndMortyApi.getLocationById(locationId = locationId)
    }
}