package com.umutcansahin.feature.episode

import com.umutcansahin.domain.model.EpisodeResultDM

fun EpisodeResultDM.toMap(): EpisodeResultUiModel {
    return EpisodeResultUiModel(
        episode = episode,
        id = id,
        name = name
    )
}