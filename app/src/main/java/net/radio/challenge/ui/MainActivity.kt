package net.radio.challenge.ui

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import net.radio.challenge.R
import net.radio.challenge.databinding.ActivityMainBinding
import net.radio.challenge.domain.model.StationModel
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: StationsListingViewModelFactory
    private val viewModel by viewModels<StationsListingViewModel> { viewModelFactory }

    // views
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViews()

        viewModel.stations().observe(this) { stations ->
            showStations(stations)
            hideLoading()
        }
        viewModel.errorMsg().observe(this) { errorMsg ->
            showError(errorMsg)
            hideLoading()
        }

        showLoading()
        viewModel.fetchStations()
    }

    private fun setupViews() {
    }

    private fun showLoading() {

    }

    private fun hideLoading() {

    }

    private fun showStations(stations: List<StationModel>){
        binding.tvInfo.text = "${stations.size}"
    }

    private fun showError(msg: String){
        binding.tvInfo.text = "ERROR: $msg"
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}