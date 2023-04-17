package com.umutcansahin.data.api

import com.umutcansahin.data.response.character.CharacterResponse
import com.umutcansahin.data.response.character.CharacterResult
import com.umutcansahin.data.response.episode.EpisodeResponse
import com.umutcansahin.data.response.episode.EpisodeResult
import com.umutcansahin.data.response.location.LocationResponse
import com.umutcansahin.data.response.location.LocationResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character/")
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ): CharacterResponse

    @GET("character/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int
    ): CharacterResult

    @GET("character/{characterGroupId}")
    suspend fun getCharacterByGroupId(
        @Path("characterGroupId") characterGroupId: String
    ): List<CharacterResult>

    @GET("episode/")
    suspend fun getAllEpisode(
        @Query("page") page: Int
    ): EpisodeResponse

    @GET("episode/{episodeId}")
    suspend fun getEpisodeById(
        @Path("episodeId") episodeId: Int
    ): EpisodeResult

    @GET("location/")
    suspend fun getAllLocation(
        @Query("page") page: Int
    ): LocationResponse

    @GET("location/{locationId}")
    suspend fun getLocationById(
        @Path("locationId") locationId: Int
    ): LocationResult
}