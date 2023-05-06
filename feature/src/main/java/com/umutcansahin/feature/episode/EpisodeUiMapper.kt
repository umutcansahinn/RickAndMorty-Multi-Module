package com.umutcansahin.feature.episode

import com.umutcansahin.domain.model.EpisodeResultDomainModel

fun EpisodeResultDomainModel.toEpisodeResultUiModel(): EpisodeResultUiModel {
    return EpisodeResultUiModel(
        episode = episode,
        id = id,
        name = name
    )
}