package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.character.*
import com.umutcansahin.domain.model.*

fun CharacterResponse.toMap(): CharacterDomainModel {
    return CharacterDomainModel(
        info = info.toMap(),
        result = result.orEmptyList().map { it.toMap() }
    )
}

fun CharacterInfo.toMap(): CharacterInfoDM {
    return CharacterInfoDM(
        count = count.orZero(),
        next = next.orEmpty(),
        pages = pages.orZero(),
        prev = prev.orEmpty()
    )
}

fun CharacterResult.toMap(): CharacterResultDM {
    return CharacterResultDM(
        created = created.orEmpty(),
        episode = episode.orEmptyList(),
        gender = gender.orEmpty(),
        id = id.orZero(),
        image = image.orEmpty(),
        location = location.toMap(),
        name = name.orEmpty(),
        origin = origin.toMap(),
        species = species.orEmpty(),
        status = status.orEmpty(),
        type = type.orEmpty(),
        url = url.orEmpty()
    )
}

fun CharacterLocation.toMap(): CharacterLocationDM {
    return CharacterLocationDM(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}

fun CharacterOrigin.toMap(): CharacterOriginDM {
    return CharacterOriginDM(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}