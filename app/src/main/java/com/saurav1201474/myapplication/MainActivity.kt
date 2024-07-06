package com.saurav1201474.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saurav1201474.myapplication.databinding.ActivityMainBinding
import com.saurav1201474.myapplication.view_models.NewYorkTimesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: NewYorkTimesViewModel
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val article = findViewById<TextView>(R.id.data)

        viewModel = ViewModelProvider(this)[NewYorkTimesViewModel::class.java]
        viewModel.articles.observe(this, Observer {
            data -> article.text = data[0].source
        })

    }
}