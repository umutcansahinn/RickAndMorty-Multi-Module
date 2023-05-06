package com.umutcansahin.feature.character

import com.umutcansahin.domain.model.CharacterResultDomainModel

fun CharacterResultDomainModel.toCharacterResultUiModel(): CharacterResultUiModel {
    return CharacterResultUiModel(
        id = id,
        image = image,
        name = name
    )
}