package com.umutcansahin.feature.location_detail

import com.umutcansahin.domain.model.CharacterResultDM
import com.umutcansahin.domain.model.LocationResultDM

fun LocationResultDM.toMap(): LocationDetailResultUiModel {
    return LocationDetailResultUiModel(
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}

fun CharacterResultDM.toMap(): CharacterGroupResultUiModel {
    return CharacterGroupResultUiModel(
        image = image
    )
}