package com.umutcansahin.feature.character

import com.umutcansahin.domain.model.CharacterResultDM

fun CharacterResultDM.toMap(): CharacterResultUiModel {
    return CharacterResultUiModel(
        id = id,
        image = image,
        name = name
    )
}