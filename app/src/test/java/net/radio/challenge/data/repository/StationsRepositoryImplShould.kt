package net.radio.challenge.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import net.radio.challenge.CoroutinesTestRule
import net.radio.challenge.common.Resource
import net.radio.challenge.data.mapper.toStationModel
import net.radio.challenge.data.remote.RadioApi
import net.radio.challenge.data.remote.dto.Playable
import net.radio.challenge.data.remote.dto.StationsResponse
import net.radio.challenge.domain.model.StationModel
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class StationsRepositoryImplShould {

    @get:Rule
    val coroutinesRule = CoroutinesTestRule()

    @Mock
    lateinit var radioApi: RadioApi

    @InjectMocks
    lateinit var stationsRepository: StationsRepositoryImpl

    private val mockPlayables = listOf(Playable())
    private val mockResponse = StationsResponse(
        "","", mockPlayables,"",100,0,100
    )
    private val mockException = Exception("Mock API exception")

    @Test
    fun `return success resource with station models`() = runBlocking {

        givenASuccessfulStationsApiCall()

        val expectedModels = mockPlayables.map { it.toStationModel() }
        // Call the function and collect the result
        val resultFlow: Flow<Resource<List<StationModel>>> = stationsRepository.getStationsListings()

        // Collect the emitted values from the flow
        val result = mutableListOf<Resource<List<StationModel>>>()
        resultFlow.collect { resource ->
            result.add(resource)
        }

        // Verify the emitted values
        assert(result.size == 1)
        assert(result[0] is Resource.Success)
        assert((result[0] as Resource.Success).data == expectedModels)
    }

    @Test(expected = RuntimeException::class)
    fun `return error resource when API call throws exception`() = runBlocking {

        givenAnApiCallFailure()

        // Call the function and collect the result
        val resultFlow: Flow<Resource<List<StationModel>>> = stationsRepository.getStationsListings()

        // Collect the emitted values from the flow
        val result = mutableListOf<Resource<List<StationModel>>>()
        resultFlow.collect { resource ->
            result.add(resource)
        }

        // Verify the emitted values
        assert(result.size == 1)
        assert(result[0] is Resource.Error)
        assert((result[0] as Resource.Error).message == "Couldn't load data, msg: ${mockException.message}")
    }

    private fun givenASuccessfulStationsApiCall() {
        runBlocking { whenever(radioApi.getStations()).thenReturn(mockResponse)}
    }

    private fun givenAnApiCallFailure() {
        runBlocking { whenever(radioApi.getStations()).thenThrow(mockException)}
    }
}