package com.umutcansahin.feature.character_detail

import com.umutcansahin.domain.model.CharacterOriginDomainModel
import com.umutcansahin.domain.model.CharacterResultDomainModel

fun CharacterResultDomainModel.toCharacterDetailResultUiModel(): CharacterDetailResultUiModel {
    return CharacterDetailResultUiModel(
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        name = name,
        origin = origin.toCharacterDetailOriginUiModel(),
        species = species,
        status = status
    )
}

fun CharacterOriginDomainModel.toCharacterDetailOriginUiModel(): CharacterDetailOriginUiModel {
    return CharacterDetailOriginUiModel(
        name = name,
        url = url
    )
}