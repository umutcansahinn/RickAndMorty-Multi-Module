package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.EpisodeResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodeByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(episodeId: Int): Resource<EpisodeResultDM> {
        return try {
            Resource.Loading
            Resource.Success(repository.getEpisodeById(episodeId = episodeId))
        }catch (e: Exception) {
            Resource.Error(e.message)
        }
    }
}