package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.character.*
import com.umutcansahin.domain.model.*

fun CharacterResponse.toCharacterDomainModel(): CharacterDomainModel {
    return CharacterDomainModel(
        info = info.toCharacterInfoDomainModel(),
        result = result.orEmptyList().map { it.toCharacterResultDomainModel() }
    )
}

fun CharacterInfo.toCharacterInfoDomainModel(): CharacterInfoDomainModel {
    return CharacterInfoDomainModel(
        count = count.orZero(),
        next = next.orEmpty(),
        pages = pages.orZero(),
        prev = prev.orEmpty()
    )
}

fun CharacterResult.toCharacterResultDomainModel(): CharacterResultDomainModel {
    return CharacterResultDomainModel(
        created = created.orEmpty(),
        episode = episode.orEmptyList(),
        gender = gender.orEmpty(),
        id = id.orZero(),
        image = image.orEmpty(),
        location = location.toCharacterLocationDomainModel(),
        name = name.orEmpty(),
        origin = origin.toCharacterOriginDomainModel(),
        species = species.orEmpty(),
        status = status.orEmpty(),
        type = type.orEmpty(),
        url = url.orEmpty()
    )
}

fun CharacterLocation.toCharacterLocationDomainModel(): CharacterLocationDomainModel {
    return CharacterLocationDomainModel(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}

fun CharacterOrigin.toCharacterOriginDomainModel(): CharacterOriginDomainModel {
    return CharacterOriginDomainModel(
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}