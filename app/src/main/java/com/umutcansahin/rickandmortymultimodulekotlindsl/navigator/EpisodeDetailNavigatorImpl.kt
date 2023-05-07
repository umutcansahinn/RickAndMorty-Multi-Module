package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.umutcansahin.feature.episode_detail.EpisodeDetailFragmentArgs
import com.umutcansahin.feature.episode_detail.EpisodeDetailNavArgs
import com.umutcansahin.feature.episode_detail.EpisodeDetailNavigator
import javax.inject.Inject

class EpisodeDetailNavigatorImpl @Inject constructor(private val fragment: Fragment) :
    EpisodeDetailNavigator {
    override fun getArgs(): EpisodeDetailNavArgs {
        with(fragment) {
            val args: EpisodeDetailFragmentArgs by navArgs()
            return EpisodeDetailNavArgs(args.episodeId)
        }
    }
}