package com.umutcansahin.feature.location_detail

import com.umutcansahin.domain.model.LocationResultDM

fun LocationResultDM.toMap(): LocationDetailResultUiModel {
    return LocationDetailResultUiModel(
        created = created,
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
        url = url
    )
}