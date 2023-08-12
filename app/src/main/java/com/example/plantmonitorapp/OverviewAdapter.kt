package com.example.plantmonitorapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

/**
 * Adapter for the [RecyclerView] in [MainActivity]
 */
class OverviewAdapter :
    RecyclerView.Adapter<OverviewAdapter.OverviewViewHolder>() {

        private val list = ('A').rangeTo('C').toList()

    class OverviewViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val button = view.findViewById<Button>(R.id.button_item)
        val text = view.findViewById<TextView>(R.id.text_item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * Creates new views with R.layout.item_view as its template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OverviewViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        return OverviewViewHolder(layout)
    }

    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: OverviewViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()
        holder.text.text = "Plant " + item.toString()

        // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
        holder.button.setOnClickListener {
            // Create an action from WordList to DetailList
            // using the required arguments
            val action =  OverviewFragmentDirections.actionOverviewFragmentToSecondFragment()
            // Navigate using that action
            holder.view.findNavController().navigate(action)
        }
    }

}