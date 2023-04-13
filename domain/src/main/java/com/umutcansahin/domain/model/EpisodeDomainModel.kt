package com.umutcansahin.domain.model

data class EpisodeDomainModel(
    val info: EpisodeInfoDM,
    val result: List<EpisodeResultDM>
)

data class EpisodeInfoDM(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class EpisodeResultDM(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)