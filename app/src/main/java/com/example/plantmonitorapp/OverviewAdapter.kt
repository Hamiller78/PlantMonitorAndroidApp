package com.example.plantmonitorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.plantmonitorapp.databinding.ItemViewBinding
import com.example.plantmonitorapp.network.PlantModel

/**
 * Adapter for the [RecyclerView] in [MainActivity]
 */
class OverviewAdapter : ListAdapter<PlantModel,
        OverviewAdapter.OverviewViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<PlantModel>() {
        override fun areItemsTheSame(oldItem: PlantModel, newItem: PlantModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PlantModel, newItem: PlantModel): Boolean {
            return oldItem == newItem
        }
    }

    class OverviewViewHolder(private var binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(plantModel: PlantModel) {
            binding.plant = plantModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        val layout = ItemViewBinding.inflate(
            LayoutInflater.from(parent.context)
        )
        return OverviewViewHolder(layout)
    }

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

//        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
//        holder.button.setOnClickListener {
//            // Create an action from WordList to DetailList
//            // using the required arguments
//            val action =  OverviewFragmentDirections.actionOverviewFragmentToSecondFragment()
//            // Navigate using that action
//            holder.view.findNavController().navigate(action)
//        }
    }

}