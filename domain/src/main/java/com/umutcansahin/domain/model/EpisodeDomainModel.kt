package com.umutcansahin.domain.model

data class EpisodeDomainModel(
    val info: EpisodeInfo,
    val result: List<EpisodeResult>
)

data class EpisodeInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class EpisodeResult(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)