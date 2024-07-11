package net.radio.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.radio.challenge.common.Resource
import net.radio.challenge.domain.model.StationModel
import net.radio.challenge.domain.repository.StationsRepository
import javax.inject.Inject

@HiltViewModel
class StationsListingViewModel @Inject constructor(
    private val stationsRepository: StationsRepository
) : ViewModel() {

    private val stations = MutableLiveData<List<StationModel>>()
    private val errorMsg = MutableLiveData<String>()
    private var fetchJob: Job? = null
    fun stations(): LiveData<List<StationModel>> = stations
    fun errorMsg(): LiveData<String> = errorMsg

    fun fetchStations() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            stationsRepository.getStationsListings().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        stations.value = result.data ?: emptyList()
                    }
                    is Resource.Error -> {
                        errorMsg.value = result.message ?: "Unexpected error!"
                    }
                }
            }
        }
    }
}