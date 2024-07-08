package com.saurav1201474.myapplication

import android.os.Bundle
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize RecyclerView and Adapter
        newYorkTimesAdapter = NewYorkTimesAdapter(this, mutableListOf())
        binding.recyclerView.apply {
            adapter = newYorkTimesAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        // Initialize ViewModel
        viewModel = ViewModelProvider(this).get(NewYorkTimesViewModel::class.java)

        // Observe LiveData from ViewModel
        viewModel.articles.observe(this, Observer { articlesModel ->
            articlesModel?.response?.docs?.let { docs ->
                // Update RecyclerView with new list of articles (docs)
                newYorkTimesAdapter.updateArticles(docs)
            }
        })

        // Fetch articles initially
        viewModel.refreshArticles()
    }
}
