package com.umutcansahin.feature.character_detail

import com.umutcansahin.domain.model.CharacterOriginDM
import com.umutcansahin.domain.model.CharacterResultDM

fun CharacterResultDM.toMap(): CharacterDetailResultUiModel {
    return CharacterDetailResultUiModel(
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        origin = origin.toMap(),
        species = species,
        status = status
    )
}

fun CharacterOriginDM.toMap(): CharacterDetailOriginUiModel {
    return CharacterDetailOriginUiModel(
        name = name,
        url = url
    )
}