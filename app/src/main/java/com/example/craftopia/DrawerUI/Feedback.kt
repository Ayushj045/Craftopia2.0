package com.example.craftopia.DrawerUI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.craftopia.R
import com.example.craftopia.databinding.ActivityFeedbackBinding
import com.example.craftopia.databinding.ActivityMainBinding

class Feedback : AppCompatActivity() {
    private lateinit var binding: ActivityFeedbackBinding
    var actionBarDrawerToggle : ActionBarDrawerToggle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSubmit.setOnClickListener {
            Toast.makeText(this,"Thanks for your feedback", Toast.LENGTH_SHORT).show()
        }
    }

}