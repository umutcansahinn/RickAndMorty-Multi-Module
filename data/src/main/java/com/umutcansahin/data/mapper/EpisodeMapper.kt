package com.umutcansahin.data.mapper

import com.umutcansahin.common.orEmpty
import com.umutcansahin.common.orEmptyList
import com.umutcansahin.common.orZero
import com.umutcansahin.data.response.episode.EpisodeInfo
import com.umutcansahin.data.response.episode.EpisodeResponse
import com.umutcansahin.data.response.episode.EpisodeResult
import com.umutcansahin.domain.model.*

fun EpisodeResponse.toEpisodeDomainModel(): EpisodeDomainModel {
    return EpisodeDomainModel(
        info = info.toEpisodeInfoDomainModel(),
        result = result.orEmptyList().map { it.toEpisodeResultDomainModel() }
    )
}

fun EpisodeInfo.toEpisodeInfoDomainModel(): EpisodeInfoDomainModel {
    return EpisodeInfoDomainModel(
        count = count.orZero(),
        next = next.orEmpty(),
        pages = pages.orZero(),
        prev.orEmpty()
    )
}

fun EpisodeResult.toEpisodeResultDomainModel(): EpisodeResultDomainModel {
    return EpisodeResultDomainModel(
        airDate = airDate.orEmpty(),
        characters = characters.orEmptyList(),
        created = created.orEmpty(),
        episode = episode.orEmpty(),
        id = id.orZero(),
        name = name.orEmpty(),
        url = url.orEmpty()
    )
}