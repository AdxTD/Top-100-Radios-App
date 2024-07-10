package net.radio.challenge.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import net.radio.challenge.common.Resource
import net.radio.challenge.data.mapper.toStationModel
import net.radio.challenge.data.remote.RadioApi
import net.radio.challenge.domain.model.StationModel
import net.radio.challenge.domain.repository.StationsRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class StationsRepositoryImpl @Inject constructor(
    private val api: RadioApi
): StationsRepository{
    override suspend fun getStationsListings(): Flow<Resource<List<StationModel>>>

    = withContext(Dispatchers.IO) {
        flow {
            val stationsResponse = try {
                api.getStations()
            } catch (e: Exception) {
                emit(Resource.Error("Couldn't load data, msg: ${e.message}"))
                null
            }
            stationsResponse?.let { response ->
                emit(Resource.Success( response.playables.map { it.toStationModel() }))
            }
        }
    }
}