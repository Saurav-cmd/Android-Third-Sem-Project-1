package com.saurav1201474.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.saurav1201474.myapplication.databinding.ActivityMainBinding
import com.saurav1201474.myapplication.view_models.NewYorkTimesViewModel
import quicktype.Doc

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewYorkTimesViewModel
    private lateinit var binding: ActivityMainBinding // Declare binding variable

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NewYorkTimesViewModel::class.java]
        viewModel.articles.observe(this, Observer { articlesModel ->
            articlesModel?.response?.docs?.let { docs ->
                if (docs.isNotEmpty()) {
                    val firstArticle: Doc = docs[0]

                    Log.d("MainActivity", "First Article: $firstArticle")

                    binding.data.text = """
                        Abstract: ${firstArticle.abstract}
                        URL: ${firstArticle.webURL}
                        Lead Paragraph: ${firstArticle.leadParagraph}
                        Source: ${firstArticle.source}
                    """.trimIndent()
                } else {
                    binding.data.text = "No articles available"
                    Log.d("MainActivity", "No articles available")
                }
            }
        })

    }
}
