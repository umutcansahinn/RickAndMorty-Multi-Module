package com.umutcansahin.domain.model

data class EpisodeDomainModel(
    val info: EpisodeInfoDomainModel,
    val result: List<EpisodeResultDomainModel>
)

data class EpisodeInfoDomainModel(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class EpisodeResultDomainModel(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)