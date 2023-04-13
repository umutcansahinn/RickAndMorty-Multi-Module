package com.umutcansahin.domain.use_case

import com.umutcansahin.domain.model.EpisodeResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetEpisodeByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(episodeId: Int): EpisodeResultDM {
        return repository.getEpisodeById(episodeId)
    }
}