package com.umutcansahin.data.repository

import androidx.paging.PagingData
import androidx.paging.map
import com.umutcansahin.data.mapper.toCharacterResultDomainModel
import com.umutcansahin.data.mapper.toEpisodeResultDomainModel
import com.umutcansahin.data.mapper.toLocationResultDomainModel
import com.umutcansahin.data.source.RemoteDataSource
import com.umutcansahin.domain.model.*
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource
) : RickAndMortyRepository {
    override fun getAllCharacter(): Flow<PagingData<CharacterResultDomainModel>> {
        return remoteDataSource.getAllCharacter().map { pagingData ->
            pagingData.map { it.toCharacterResultDomainModel() }
        }
    }

    override fun getAllEpisode(): Flow<PagingData<EpisodeResultDomainModel>> {
        return remoteDataSource.getAllEpisode().map { pagingData ->
            pagingData.map { it.toEpisodeResultDomainModel() }
        }
    }

    override fun getAllLocation(): Flow<PagingData<LocationResultDomainModel>> {
        return remoteDataSource.getAllLocation().map { pagingData ->
            pagingData.map { it.toLocationResultDomainModel() }
        }
    }

    override suspend fun getCharacterById(characterId: Int): CharacterResultDomainModel {
        return remoteDataSource.getCharacterById(characterId).toCharacterResultDomainModel()
    }

    override suspend fun getCharacterByGroupId(characterGroupId: String): List<CharacterResultDomainModel> {
        return remoteDataSource.getCharacterByGroupId(characterGroupId)
            .map { it.toCharacterResultDomainModel() }
    }

    override suspend fun getEpisodeById(episodeId: Int): EpisodeResultDomainModel {
        return remoteDataSource.getEpisodeById(episodeId).toEpisodeResultDomainModel()
    }

    override suspend fun getLocationById(locationId: Int): LocationResultDomainModel {
        return remoteDataSource.getLocationById(locationId).toLocationResultDomainModel()
    }
}