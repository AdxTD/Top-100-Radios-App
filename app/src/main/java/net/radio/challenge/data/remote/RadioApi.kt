package net.radio.challenge.data.remote

import com.example.example.StationsResponse
import retrofit2.http.GET

interface RadioApi {

    companion object {

        const val BASE_URL = "https://beta.radio-api.net/"
        const val STATIONS_COUNT = 100
    }

    @GET("stations/list-by-system-name?systemName=STATIONS_TOP&count=${STATIONS_COUNT}")
    suspend fun getStations(): StationsResponse
}