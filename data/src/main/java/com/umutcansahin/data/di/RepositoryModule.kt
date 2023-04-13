package com.umutcansahin.data.di

import com.umutcansahin.data.repository.RickAndMortyRepositoryImpl
import com.umutcansahin.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRickAndMortyRepository(
        rickAndMortyRepositoryImpl: RickAndMortyRepositoryImpl
    ): RickAndMortyRepository
}