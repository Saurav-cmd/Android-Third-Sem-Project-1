package com.saurav1201474.myapplication.view

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.saurav1201474.myapplication.databinding.ActivityWebDesignBinding


class WebDesignActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityWebDesignBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        val webView = binding.webview

        val url = intent.getStringExtra("Url")
        if (!url.isNullOrEmpty()) {
            webView.loadUrl(url)
        }

    }
}