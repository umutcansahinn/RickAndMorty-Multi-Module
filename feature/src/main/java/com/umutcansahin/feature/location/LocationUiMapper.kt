package com.umutcansahin.feature.location

import com.umutcansahin.domain.model.LocationResultDomainModel

fun LocationResultDomainModel.toLocationResultUiModel(): LocationResultUiModel {
    return LocationResultUiModel(
        id = id,
        name = name
    )
}