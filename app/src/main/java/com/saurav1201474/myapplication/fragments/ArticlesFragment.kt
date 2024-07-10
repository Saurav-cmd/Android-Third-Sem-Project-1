package com.saurav1201474.myapplication.fragments

import Doc
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurav1201474.myapplication.MainActivity
import com.saurav1201474.myapplication.adapter.NewYorkTimesAdapter
import com.saurav1201474.myapplication.databinding.FragmentArticlesBinding
import com.saurav1201474.myapplication.view_models.NewYorkTimesViewModel

class ArticlesFragment : Fragment() {

    private lateinit var viewModel: NewYorkTimesViewModel
    private lateinit var binding: FragmentArticlesBinding
    private lateinit var newYorkTimesAdapter: NewYorkTimesAdapter

    private val articles = mutableListOf<Doc>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentArticlesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel = (requireActivity() as MainActivity).getNewYorkTimesViewModel()
        observeViewModel()

        // Setup swipe to refresh listener
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refreshArticle()
        }
    }

    private fun setupRecyclerView() {
        newYorkTimesAdapter = NewYorkTimesAdapter(requireContext(), articles)
        binding.recyclerView.apply {
            adapter = newYorkTimesAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    private fun observeViewModel() {
        viewModel.articles.observe(viewLifecycleOwner, Observer { articlesModel ->
            articlesModel?.response?.docs?.let { docs ->
                newYorkTimesAdapter.updateArticles(docs)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.loading.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.swipeRefreshLayout.isRefreshing = isLoading
            binding.fragmentArticleMainContainer.visibility = if (isLoading) View.GONE else View.VISIBLE
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
