package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.location.LocationInfo
import com.umutcansahin.data.response.location.LocationResponse
import com.umutcansahin.data.response.location.LocationResult
import com.umutcansahin.domain.model.*

fun LocationResponse.toLocationDomainModel(): LocationDomainModel {
    return LocationDomainModel(
        info = info.toLocationInfoDomainModel(),
        result = result.orEmptyList().map { it.toLocationResultDomainModel() }
    )
}

fun LocationInfo.toLocationInfoDomainModel(): LocationInfoDomainModel {
    return LocationInfoDomainModel(
        count = count.orZero(),
        next = next.orEmpty(),
        pages = pages.orZero(),
        prev = prev.orEmpty()
    )
}

fun LocationResult.toLocationResultDomainModel(): LocationResultDomainModel {
    return LocationResultDomainModel(
        created = created.orEmpty(),
        dimension = dimension.orEmpty(),
        id = id.orZero(),
        name = name.orEmpty(),
        residents = residents.orEmptyList(),
        type = type.orEmpty(),
        url = url.orEmpty()
    )
}