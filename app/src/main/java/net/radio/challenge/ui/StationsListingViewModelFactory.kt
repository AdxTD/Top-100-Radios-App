package net.radio.challenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.radio.challenge.domain.repository.StationsRepository
import javax.inject.Inject

class StationsListingViewModelFactory @Inject constructor(
    private val stationsRepository: StationsRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = StationsListingViewModel(stationsRepository) as T
}
