package com.suonk.caen_festival.ui.places

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.suonk.caen_festival.databinding.PlaceItemLayoutBinding

class PlacesListAdapter : ListAdapter<PlaceItemViewState, PlacesListAdapter.ViewHolder>(PlacesComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PlaceItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    class ViewHolder(private val binding: PlaceItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(place: PlaceItemViewState) {
            Log.i("GetPlace", "place.pictureUrl : ${place.pictureUrl}")
            binding.placeTitle.text = place.title
            Glide.with(binding.placeImage).load(place.pictureUrl).into(binding.placeImage)
        }
    }

    object PlacesComparator : DiffUtil.ItemCallback<PlaceItemViewState>() {
        override fun areItemsTheSame(oldItem: PlaceItemViewState, newItem: PlaceItemViewState) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PlaceItemViewState, newItem: PlaceItemViewState): Boolean = oldItem == newItem
    }
}