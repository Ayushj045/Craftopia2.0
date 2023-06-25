package com.example.craftopia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.craftopia.databinding.ActivityDashboardBinding
import com.example.craftopia.databinding.ActivityMainBinding

class Dashboard : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    }