package com.saurav1201474.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.saurav1201474.myapplication.databinding.ActivityMainBinding

class AboutActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        val newYorkDetails = """
            The New York Times Developer API offers various tools for integrating NYT content into applications. 
            Key APIs include the Article Search API for finding NYT articles, the Top Stories API for fetching top stories across different sections, 
            the Most Popular API for accessing the most viewed, shared, and emailed articles, and the Movie Reviews API for NYT movie reviews. 
            These APIs provide a robust way to incorporate NYT's rich content into your applications.
        """.trimIndent()
        var detailView= findViewById<TextView>(R.id.detailView)
        detailView.text=newYorkDetails


    }
}