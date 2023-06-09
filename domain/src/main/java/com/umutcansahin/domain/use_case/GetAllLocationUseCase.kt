package com.umutcansahin.domain.use_case

import androidx.paging.PagingData
import com.umutcansahin.domain.model.LocationResultDomainModel
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllLocationUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(): Flow<PagingData<LocationResultDomainModel>> {
        return repository.getAllLocation()
    }
}