package com.umutcansahin.feature.location

import com.umutcansahin.domain.model.LocationResultDM

fun LocationResultDM.toMap(): LocationResultUiModel {
    return LocationResultUiModel(
        created = created,
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}