package com.umutcansahin.feature.episode_detail

import com.umutcansahin.domain.model.CharacterResultDomainModel
import com.umutcansahin.domain.model.EpisodeResultDomainModel

fun EpisodeResultDomainModel.toEpisodeDetailResultUiModel(): EpisodeDetailResultUiModel {
    return EpisodeDetailResultUiModel(
        airDate = airDate,
        characters = characters,
        created = created,
        episode = episode,
        id = id,
        name = name,
        url = url
    )
}

fun CharacterResultDomainModel.toCharacterGroupResultUiModel(): CharacterGroupResultUiModel {
    return CharacterGroupResultUiModel(
        image = image
    )
}