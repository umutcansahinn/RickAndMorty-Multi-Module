package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.LocationResultDomainModel
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetLocationByIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    suspend operator fun invoke(locationId: Int): Flow<Resource<LocationResultDomainModel>> = flow {
        emit(Resource.Loading)
        emit(Resource.Success(repository.getLocationById(locationId)))
    }.catch {
        emit(Resource.Error(it.message))
    }
}