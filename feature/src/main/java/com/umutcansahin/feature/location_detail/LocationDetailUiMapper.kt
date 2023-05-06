package com.umutcansahin.feature.location_detail

import com.umutcansahin.domain.model.CharacterResultDomainModel
import com.umutcansahin.domain.model.LocationResultDomainModel

fun LocationResultDomainModel.toLocationDetailResultUiModel(): LocationDetailResultUiModel {
    return LocationDetailResultUiModel(
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}

fun CharacterResultDomainModel.toCharacterGroupResultUiModel(): CharacterGroupResultUiModel {
    return CharacterGroupResultUiModel(
        image = image
    )
}