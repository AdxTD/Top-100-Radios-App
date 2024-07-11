package net.radio.challenge.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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

    private lateinit var recyclerAdapter: StationsListRecyclerAdapter

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

        setupRecycler()

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

    private fun setupRecycler(){
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = StationsListRecyclerAdapter()
        binding.recyclerView.adapter = recyclerAdapter

        val itemDecoration = DividerItemDecoration(this, (binding.recyclerView.layoutManager as LinearLayoutManager).orientation)
        val dividerDrawable: Drawable = resources.getDrawable(R.drawable.divider)
        itemDecoration.setDrawable(dividerDrawable)
        binding.recyclerView.addItemDecoration(itemDecoration)

        binding.swipeRefreshLayout.setOnRefreshListener { viewModel.fetchStations() }
        binding.btnRetry.setOnClickListener { viewModel.fetchStations() }
    }

    private fun showLoading() {
        binding.swipeRefreshLayout.isRefreshing = true
        binding.containerProgressbar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.swipeRefreshLayout.isRefreshing = false
        binding.containerProgressbar.visibility = View.GONE
    }

    private fun showStations(stations: List<StationModel>){
        hideLoading()
        if(stations.isEmpty()){
            binding.containerError.visibility = View.VISIBLE
            binding.tvInfo.text = "No Data !"
            return
        }
        binding.containerError.visibility = View.GONE
        recyclerAdapter.updateItems(stations)
    }

    private fun showError(msg: String){
        hideLoading()
        if(recyclerAdapter.itemCount == 0) {
            binding.containerError.visibility = View.VISIBLE
            binding.tvInfo.text = msg
        }
        else
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }
}