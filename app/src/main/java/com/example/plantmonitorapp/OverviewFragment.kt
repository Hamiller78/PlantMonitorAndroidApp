package com.example.plantmonitorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plantmonitorapp.databinding.FragmentOverviewBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //val binding = FragmentOverviewBinding.inflate(inflater)
        val binding = DataBindingUtil.inflate(inflater, R.layout.fragment_overview, container, false) as FragmentOverviewBinding
        binding.lifecycleOwner = this

        binding.viewModel = viewModel
        binding.overviewView.adapter = OverviewAdapter()

        return binding.root
    }
}