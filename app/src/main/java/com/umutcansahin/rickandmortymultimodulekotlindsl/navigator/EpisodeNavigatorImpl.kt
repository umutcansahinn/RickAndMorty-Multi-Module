package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.umutcansahin.feature.episode.EpisodeFragmentDirections
import com.umutcansahin.feature.episode.EpisodeNavigator
import com.umutcansahin.rickandmortymultimodulekotlindsl.R
import javax.inject.Inject

class EpisodeNavigatorImpl @Inject constructor(private val fragment: Fragment) :
    EpisodeNavigator {
    override fun navigate(episodeId: Int) {
        Navigation.findNavController(fragment.requireActivity(), R.id.fragmentContainer).navigate(
            EpisodeFragmentDirections.actionEpisodeFragmentToEpisodeDetailFragment(episodeId = episodeId)
        )
    }
}