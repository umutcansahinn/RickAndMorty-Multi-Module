package com.umutcansahin.feature.character_detail

import com.umutcansahin.domain.model.CharacterLocationDM
import com.umutcansahin.domain.model.CharacterOriginDM
import com.umutcansahin.domain.model.CharacterResultDM

fun CharacterResultDM.toMap(): CharacterDetailResultUiModel {
    return CharacterDetailResultUiModel(
        created = created,
        episode = episode,
        gender = gender,
        id = id,
        image = image,
        location = location.toMap(),
        name = name,
        origin = origin.toMap(),
        species = species,
        status = status,
        type = type,
        url = url
    )
}

fun CharacterLocationDM.toMap(): CharacterDetailLocationUiModel {
    return CharacterDetailLocationUiModel(
        name = name,
        url = url
    )
}

fun CharacterOriginDM.toMap(): CharacterDetailOriginUiModel {
    return CharacterDetailOriginUiModel(
        name = name,
        url = url
    )
}