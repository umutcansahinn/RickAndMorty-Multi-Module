package com.umutcansahin.feature.episode_detail

data class EpisodeDetailResultUiModel(
    val airDate: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
    val url: String
)