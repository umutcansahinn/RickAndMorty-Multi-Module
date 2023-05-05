package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.EpisodeResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetEpisodeByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(episodeId: Int): Flow<Resource<EpisodeResultDM>> = flow {
        emit(Resource.Loading)
        emit(Resource.Success(repository.getEpisodeById(episodeId)))
    }.catch {
        emit(Resource.Error(it.message))
    }
}