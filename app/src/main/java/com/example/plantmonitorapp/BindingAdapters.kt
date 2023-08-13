package com.example.plantmonitorapp

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.plantmonitorapp.network.PlantModel

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<PlantModel>?) {
    val adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(data)
}

