package com.umutcansahin.rickandmortymultimodulekotlindsl.navigator

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.umutcansahin.feature.location.LocationFragmentDirections
import com.umutcansahin.feature.location.LocationNavigator
import com.umutcansahin.rickandmortymultimodulekotlindsl.R
import javax.inject.Inject

class LocationNavigatorImpl @Inject constructor(private val fragment: Fragment) :
    LocationNavigator {
    override fun navigate(locationId: Int) {
        Navigation.findNavController(fragment.requireActivity(), R.id.fragmentContainer).navigate(
            LocationFragmentDirections.actionLocationFragmentToLocationDetailFragment(locationId = locationId)
        )
    }
}