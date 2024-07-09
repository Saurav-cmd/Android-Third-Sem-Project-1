package com.saurav1201474.myapplication

import ArticlesModel
import Doc
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.saurav1201474.myapplication.adapter.NewYorkTimesAdapter
import com.saurav1201474.myapplication.databinding.ActivityMainBinding
import com.saurav1201474.myapplication.view_models.NewYorkTimesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewYorkTimesViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var newYorkTimesAdapter: NewYorkTimesAdapter
    private val articles = mutableListOf<Doc>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and Adapter
        newYorkTimesAdapter = NewYorkTimesAdapter(this, articles)
        binding.recyclerView.apply {
            adapter = newYorkTimesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.recyclerView.adapter = newYorkTimesAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[NewYorkTimesViewModel::class.java]

        // Observe LiveData from ViewModel
        viewModel.articles.observe(this, Observer { articlesModel ->
            articlesModel?.response?.docs?.let { docs ->
                // Update RecyclerView with new list of articles (docs)
                newYorkTimesAdapter.updateArticles(docs)
            }
        })

        viewModel.isLoading.observe(this, Observer { isLoading ->
            binding.progressCircular.visibility = if (isLoading) View.VISIBLE else View.GONE
        })

        viewModel.isLoadingText.observe(this, Observer { isLoadingText ->
            binding.loading.visibility = if (isLoadingText) View.VISIBLE else View.GONE

        })

        viewModel.refreshArticles()
    }
}
