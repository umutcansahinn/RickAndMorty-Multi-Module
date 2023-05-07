package com.umutcansahin.feature.character_detail

interface CharacterDetailNavigator {
    fun getArgs(): CharacterDetailNavArgs
    fun navigate(episodeId: Int)
}

data class CharacterDetailNavArgs(val characterId: Int)