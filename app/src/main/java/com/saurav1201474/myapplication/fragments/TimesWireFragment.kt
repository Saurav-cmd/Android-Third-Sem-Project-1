package com.saurav1201474.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import bhuwan.Result
import bhuwan.TimesWireModal
import com.saurav1201474.myapplication.adapter.TimesWireAdapter
import com.saurav1201474.myapplication.databinding.FragmentTimesWireBinding
import com.saurav1201474.myapplication.view_models.TimesWireViewModel

class TimesWireFragment : Fragment() {

    private lateinit var binding: FragmentTimesWireBinding
    private val viewModel: TimesWireViewModel by viewModels()
    private lateinit var timeWireAdapter: TimesWireAdapter
    private val timeWires = mutableListOf<Result>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTimesWireBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()

        // Fetch data
        viewModel.refreshArticle()
    }

    private fun setupRecyclerView() {
        timeWireAdapter = TimesWireAdapter(requireContext(), timeWires)
        binding.recyclerView.apply {
            adapter = timeWireAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun setupObservers() {
        viewModel.timesWire.observe(viewLifecycleOwner, Observer { timesWire ->
//            timeWireAdapter.updateTimeWire(timeWires)
            timesWire?.results?.let { results ->
                timeWireAdapter.updateTimeWire(results)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.swipeRefreshLayout.isRefreshing = isLoading
            binding.topStoriesFragmentMainContainer.visibility = if (isLoading) View.GONE else View.VISIBLE
        })
    }
}
