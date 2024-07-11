package net.radio.challenge.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import net.radio.challenge.databinding.StationListItemBinding
import net.radio.challenge.domain.model.StationModel

class StationsListRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var stations: List<StationModel> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = StationListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val stationHolder = holder as StationViewHolder
        val item = stations[position]
        stationHolder.bind(item)
    }

    override fun getItemCount() = stations.size

    fun updateItems(newStations: List<StationModel>) {
        val diffResult = DiffUtil.calculateDiff(ItemsDiffCallback(this.stations, newStations))
        this.stations = newStations
        diffResult.dispatchUpdatesTo(this)
    }

    private class StationViewHolder(private val binding: StationListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(station: StationModel) {
            binding.tvName.text = station.name
            val genres = if(station.genres.isNotEmpty()) ", " + station.genres.joinToString(", ") else ""
            binding.tvCountry.text = station.country + genres
            binding.tvTopics.text = station.topics.joinToString(", ")
            binding.imageviewCover.load(station.logo300x300)
        }
    }

    private class ItemsDiffCallback(private val oldItems: List<StationModel>, private val newItems: List<StationModel>) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldItems.size
        }
        override fun getNewListSize(): Int {
            return newItems.size
        }
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItems[oldItemPosition].id == newItems[newItemPosition].id
        }
        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItems[oldItemPosition].name == newItems[newItemPosition].name
        }
    }
}
