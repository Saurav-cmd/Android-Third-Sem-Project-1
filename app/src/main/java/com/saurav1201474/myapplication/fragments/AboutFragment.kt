package com.saurav1201474.myapplication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.saurav1201474.myapplication.databinding.FragmentAboutBinding
import com.saurav1201474.myapplication.databinding.FragmentAboutBinding.inflate

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newYorkDetails =
            (" The New York Times Developer API offers various tools for integrating NYT content into applications. \n \n " +
                    "Key APIs include the Article Search API for finding NYT articles, the Top Stories API for fetching top stories across different sections, the Most Popular API for accessing the most viewed, shared, and emailed articles, and the Movie Reviews API for NYT movie reviews. \n\n " +
                    "These APIs provide a robust way to incorporate NYT's rich content into your applications.").trimIndent()

        binding.details.text = newYorkDetails
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}
