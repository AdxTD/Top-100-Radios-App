package net.radio.challenge.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import net.radio.challenge.CoroutinesTestRule
import net.radio.challenge.common.Resource
import net.radio.challenge.domain.model.StationModel
import net.radio.challenge.domain.repository.StationsRepository
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.whenever

@RunWith(MockitoJUnitRunner::class)
class StationsListingViewModelShould {

    @get:Rule
    val liveDataRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = CoroutinesTestRule()

    @Mock
    lateinit var stationsRepository: StationsRepository

    @InjectMocks
    lateinit var viewModel: StationsListingViewModel

    private val mockStations: List<StationModel> = listOf(Mockito.mock(), Mockito.mock(), Mockito.mock())
    private val mockErrorMsg: String = "error msg"

    @Test
    fun callGetStationsListingsOnRepositoryWhenFetchStationsIsCalled() = runTest {
        givenASuccessfulStationsApiCall(mockStations)
        viewModel.fetchStations()
        Mockito.verify(stationsRepository).getStationsListings()
    }

    @Test
    fun showStationsOnViewWhenFetchStationsIsSuccessful() {
        givenASuccessfulStationsApiCall(mockStations)
        viewModel.fetchStations()
        viewModel.stations().observeForever {
            Assert.assertEquals(mockStations, it)
        }
    }

    @Test
    fun showErrorOnViewWhenFetchStationsIsAFailure() {
        givenAnApiCallFailure()
        viewModel.fetchStations()
        viewModel.errorMsg().observeForever {
            Assert.assertEquals(mockErrorMsg, it)
        }
    }

    private fun givenASuccessfulStationsApiCall(result: List<StationModel>) {
        runBlocking { whenever(stationsRepository.getStationsListings()).thenReturn(flow {
            emit(Resource.Success(result))
        }) }
    }

    private fun givenAnApiCallFailure() {
        runBlocking { whenever(stationsRepository.getStationsListings()).thenReturn(flow {
            emit(Resource.Error(mockErrorMsg))
        }) }
    }
}