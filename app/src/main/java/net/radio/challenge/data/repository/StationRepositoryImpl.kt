package net.radio.challenge.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import net.radio.challenge.data.mapper.toStationModel
import net.radio.challenge.data.remote.RadioApi
import net.radio.challenge.domain.model.StationModel
import net.radio.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class StationRepositoryImpl @Inject constructor(
    private val api: RadioApi
): StationsRepository{
    override suspend fun getStationsListings(): Flow<List<StationModel>>
    = withContext(Dispatchers.IO) {
        val stationsResponse = api.getStations()
        flow {
            emit(stationsResponse.playables.map {
                it.toStationModel()
            })
        }
    }
}