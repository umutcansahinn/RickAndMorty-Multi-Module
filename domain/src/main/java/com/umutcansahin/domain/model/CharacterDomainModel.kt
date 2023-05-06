package com.umutcansahin.domain.model

data class CharacterDomainModel(
    val info: CharacterInfoDomainModel,
    val result: List<CharacterResultDomainModel>
)

data class CharacterInfoDomainModel(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

data class CharacterResultDomainModel(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocationDomainModel,
    val name: String,
    val origin: CharacterOriginDomainModel,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

data class CharacterLocationDomainModel(
    val name: String,
    val url: String
)

data class CharacterOriginDomainModel(
    val name: String,
    val url: String
)