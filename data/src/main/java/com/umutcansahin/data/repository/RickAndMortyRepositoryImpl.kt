package com.umutcansahin.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.umutcansahin.common.orEmpty
import com.umutcansahin.data.mapper.toMap
import com.umutcansahin.data.source.RemoteDataSource
import com.umutcansahin.domain.model.*
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RickAndMortyRepository {
    override fun getAllCharacter(): Flow<PagingData<CharacterResultDM>> {
        return remoteDataSource.getAllCharacter().map { pagingData ->
            pagingData.map { it.toMap() }
        }
    }

    override fun getAllEpisode(): Flow<PagingData<EpisodeResultDM>> {
        return remoteDataSource.getAllEpisode().map { pagingData ->
            pagingData.map { it.toMap() }
        }
    }

    override fun getAllLocation(): Flow<PagingData<LocationResultDM>> {
        return remoteDataSource.getAllLocation().map { pagingData ->
            pagingData.map { it.toMap() }
        }
    }

    override suspend fun getCharacterById(characterId: Int): CharacterResultDM {
        return remoteDataSource.getCharacterById(characterId).toMap()
    }

    override suspend fun getCharacterByGroupId(characterGroupId: String): List<CharacterResultDM> {
        return remoteDataSource.getCharacterByGroupId(characterGroupId).map { it.toMap() }
    }

    override suspend fun getEpisodeById(episodeId: Int): EpisodeResultDM {
        return remoteDataSource.getEpisodeById(episodeId).toMap()
    }

    override suspend fun getLocationById(locationId: Int): LocationResultDM {
        return remoteDataSource.getLocationById(locationId).toMap()
    }
}