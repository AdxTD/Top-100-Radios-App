package net.radio.challenge.domain.repository

import kotlinx.coroutines.flow.Flow
import net.radio.challenge.common.Resource
import net.radio.challenge.domain.model.StationModel

interface StationsRepository {

    suspend fun getStationsListings(): Flow<Resource<List<StationModel>>>
}