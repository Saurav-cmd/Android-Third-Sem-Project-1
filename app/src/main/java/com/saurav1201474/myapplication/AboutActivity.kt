package com.saurav1201474.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saurav1201474.myapplication.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newYorkDetails =
            (" The New York Times Developer API offers various tools for integrating NYT content into applications. \n \n " +
                    "Key APIs include the Article Search API for finding NYT articles, the Top Stories API for fetching top stories across different sections, the Most Popular API for accessing the most viewed, shared, and emailed articles, and the Movie Reviews API for NYT movie reviews. \n\n " +
                    "These APIs provide a robust way to incorporate NYT's rich content into your applications.").trimIndent()

        binding.details.text = newYorkDetails


    }
}