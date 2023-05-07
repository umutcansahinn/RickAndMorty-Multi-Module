package com.umutcansahin.feature.episode_detail

interface EpisodeDetailNavigator {
    fun getArgs(): EpisodeDetailNavArgs
}

data class EpisodeDetailNavArgs(val episodeId: Int)