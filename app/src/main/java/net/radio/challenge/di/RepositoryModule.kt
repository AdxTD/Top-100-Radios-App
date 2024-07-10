package net.radio.challenge.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.radio.challenge.data.repository.StationsRepositoryImpl
import net.radio.challenge.domain.repository.StationsRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindStationsRepository(
        stationsRepository: StationsRepositoryImpl
    ): StationsRepository
}