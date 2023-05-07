package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import com.umutcansahin.feature.character.CharacterNavigator
import com.umutcansahin.feature.character_detail.CharacterDetailNavigator
import com.umutcansahin.feature.character_detail_bottom_sheet.CharacterBottomSheetNavigator
import com.umutcansahin.feature.episode.EpisodeNavigator
import com.umutcansahin.feature.episode_detail.EpisodeDetailNavigator
import com.umutcansahin.feature.location.LocationNavigator
import com.umutcansahin.feature.location_detail.LocationDetailNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface NavigationModule {
    @Binds
    fun bindCharacterBottomSheetNavigator(characterBottomSheetNavigatorImpl: CharacterBottomSheetNavigatorImpl): CharacterBottomSheetNavigator

    @Binds
    fun bindCharacterDetailNavigator(characterDetailNavigatorImpl: CharacterDetailNavigatorImpl): CharacterDetailNavigator

    @Binds
    fun bindCharacterNavigator(characterNavigator: CharacterNavigatorImpl): CharacterNavigator

    @Binds
    fun bindEpisodeDetailNavigator(episodeDetailNavigator: EpisodeDetailNavigatorImpl): EpisodeDetailNavigator

    @Binds
    fun bindEpisodeNavigator(episodeNavigator: EpisodeNavigatorImpl): EpisodeNavigator

    @Binds
    fun bindLocationDetailNavigator(locationDetailNavigator: LocationDetailNavigatorImpl): LocationDetailNavigator

    @Binds
    fun bindLocationNavigator(locationNavigator: LocationNavigatorImpl): LocationNavigator
}