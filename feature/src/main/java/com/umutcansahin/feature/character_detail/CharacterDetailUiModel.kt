package com.umutcansahin.feature.character_detail

data class CharacterDetailResultUiModel(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val origin: CharacterDetailOriginUiModel,
     val species: String,
    val status: String
)

data class CharacterDetailOriginUiModel(
    val name: String,
    val url: String
)