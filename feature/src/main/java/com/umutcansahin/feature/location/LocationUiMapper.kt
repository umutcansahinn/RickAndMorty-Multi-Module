package com.umutcansahin.feature.location

import com.umutcansahin.domain.model.LocationResultDM

fun LocationResultDM.toMap(): LocationResultUiModel {
    return LocationResultUiModel(
        id = id,
        name = name
    )
}