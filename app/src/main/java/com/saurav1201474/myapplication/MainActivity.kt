package com.saurav1201474.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.saurav1201474.myapplication.databinding.ActivityMainBinding
import com.saurav1201474.myapplication.view_models.NewYorkTimesViewModel
import com.saurav1201474.myapplication.view_models.TopStoriesViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NewYorkTimesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize ViewModel
        viewModel =
            ViewModelProvider(this)[NewYorkTimesViewModel::class.java]

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
                ?: return

        val navController = navHostFragment.navController
        val bottomNavigationView: BottomNavigationView = binding.bottomNavView

        NavigationUI.setupWithNavController(bottomNavigationView, navController)
    }

    // Optionally, provide access to ViewModel to fragments if needed
    fun getNewYorkTimesViewModel(): NewYorkTimesViewModel {
        return viewModel
    }


}

