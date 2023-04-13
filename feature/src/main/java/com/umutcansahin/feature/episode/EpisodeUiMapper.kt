package com.umutcansahin.feature.episode

import com.umutcansahin.domain.model.EpisodeResultDM

fun EpisodeResultDM.toMap(): EpisodeResultUiModel {
    return EpisodeResultUiModel(
        airDate = airDate,
        characters = characters,
        created = created,
        episode = episode,
        id = id,
        name = name,
        url = url
    )
}