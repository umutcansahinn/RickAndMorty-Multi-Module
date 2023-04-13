package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.location.LocationInfo
import com.umutcansahin.data.response.location.LocationResponse
import com.umutcansahin.data.response.location.LocationResult
import com.umutcansahin.domain.model.LocationDomainModel
import com.umutcansahin.domain.model.LocationInfoDM
import com.umutcansahin.domain.model.LocationResultDM

fun LocationResponse.toMap(): LocationDomainModel {
    return LocationDomainModel(
        info = info.toMap(),
        result = result.orEmptyList().map { it.toMap() }
    )
}

fun LocationInfo.toMap(): LocationInfoDM {
    return LocationInfoDM(
        count = count.orZero(),
        next = next.orEmpty(),
        pages = pages.orZero(),
        prev = prev.orEmpty()
    )
}

fun LocationResult.toMap(): LocationResultDM {
    return LocationResultDM(
        created = created.orEmpty(),
        dimension = dimension.orEmpty(),
        id = id.orZero(),
        name = name.orEmpty(),
        residents = residents.orEmptyList(),
        type = type.orEmpty(),
        url = url.orEmpty()
    )
}