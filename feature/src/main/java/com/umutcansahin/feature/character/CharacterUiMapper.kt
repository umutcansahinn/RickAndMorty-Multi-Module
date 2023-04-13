package com.umutcansahin.feature.character

import com.umutcansahin.domain.model.CharacterLocationDM
import com.umutcansahin.domain.model.CharacterOriginDM
import com.umutcansahin.domain.model.CharacterResultDM

fun CharacterResultDM.toMap(): CharacterResultUiModel {
    return CharacterResultUiModel(
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

fun CharacterLocationDM.toMap(): CharacterLocationUiModel {
    return CharacterLocationUiModel(
        name = name,
        url = url
    )
}

fun CharacterOriginDM.toMap(): CharacterOriginUiModel {
    return CharacterOriginUiModel(
        name = name,
        url = url
    )
}