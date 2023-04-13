package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.episode.EpisodeInfo
import com.umutcansahin.data.response.episode.EpisodeResponse
import com.umutcansahin.data.response.episode.EpisodeResult
import com.umutcansahin.domain.model.EpisodeDomainModel
import com.umutcansahin.domain.model.EpisodeInfoDM
import com.umutcansahin.domain.model.EpisodeResultDM

fun EpisodeResponse.toMap(): EpisodeDomainModel {
    return EpisodeDomainModel(
        info = info.toMap(),
        result = result.orEmptyList().map { it.toMap() }
    )
}

fun EpisodeInfo.toMap(): EpisodeInfoDM {
    return EpisodeInfoDM(
        count = count.orZero(),
        next = next.orEmpty(),
        pages = pages.orZero(),
        prev.orEmpty()
    )
}

fun EpisodeResult.toMap(): EpisodeResultDM {
    return EpisodeResultDM(
        airDate = airDate.orEmpty(),
        characters = characters.orEmptyList(),
        created = created.orEmpty(),
        episode = episode.orEmpty(),
        id = id.orZero(),
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}