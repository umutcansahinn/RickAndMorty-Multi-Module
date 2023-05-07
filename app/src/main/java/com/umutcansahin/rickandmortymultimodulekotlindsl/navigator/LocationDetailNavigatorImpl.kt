package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.umutcansahin.feature.location_detail.LocationDetailFragmentArgs
import com.umutcansahin.feature.location_detail.LocationDetailNavArgs
import com.umutcansahin.feature.location_detail.LocationDetailNavigator
import javax.inject.Inject

class LocationDetailNavigatorImpl @Inject constructor(private val fragment: Fragment) :
    LocationDetailNavigator {
    override fun getArgs(): LocationDetailNavArgs {
        with(fragment) {
            val args: LocationDetailFragmentArgs by navArgs()
            return LocationDetailNavArgs(args.locationId)
        }
    }
}