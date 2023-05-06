package com.umutcansahin.domain.use_case

import com.umutcansahin.common.Resource
import com.umutcansahin.domain.model.CharacterResultDomainModel
import com.umutcansahin.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterByGroupIdUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(characterGroupId: String): Flow<Resource<List<CharacterResultDomainModel>>> = flow {
        emit(Resource.Loading)
        emit(Resource.Success(repository.getCharacterByGroupId(characterGroupId)))
    }.catch {
        emit(Resource.Error(it.message))
    }
}