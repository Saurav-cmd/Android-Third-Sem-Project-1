package com.saurav1201474.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurav1201474.myapplication.adapter.TopStoriesAdapter
import com.saurav1201474.myapplication.databinding.FragmentTopStoriesBinding
import com.saurav1201474.myapplication.models.Result
import com.saurav1201474.myapplication.view_models.TopStoriesViewModel

class TopStoriesFragment : Fragment() {

    private lateinit var binding: FragmentTopStoriesBinding
    private val viewModel: TopStoriesViewModel by viewModels()
    private lateinit var topStoriesAdapter: TopStoriesAdapter
    private val topStories = mutableListOf<Result>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTopStoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.topStories.observe(viewLifecycleOwner, Observer { results ->
            results.results?.let { results ->
                topStoriesAdapter.updateTopStory(results)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.swipeRefreshLayout.isRefreshing = isLoading
            binding.topStoriesFragmentMainContainer.visibility = if (isLoading) View.GONE else View.VISIBLE
        })
    }

    private fun setupRecyclerView() {
        topStoriesAdapter = TopStoriesAdapter(requireContext(), topStories)
        binding.recyclerView.apply {
            adapter = topStoriesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

}
