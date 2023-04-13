package com.umutcansahin.domain.use_case

import com.umutcansahin.domain.model.LocationResultDM
import com.umutcansahin.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetLocationByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(locationId: Int): LocationResultDM {
        return repository.getLocationById(locationId)
    }
}