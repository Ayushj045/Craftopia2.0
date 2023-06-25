package com.example.craftopia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.craftopia.DrawerUI.Feedback
import com.example.craftopia.DrawerUI.Seller
import com.example.craftopia.DrawerUI.Settings
import com.example.craftopia.databinding.ActivityMainBinding
import com.google.android.material.internal.NavigationMenuItemView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() , NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    var actionBarDrawerToggle : ActionBarDrawerToggle ? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportActionBar?.title = "MainActivity"

        val drawerLayout = binding.drawerLayout
         actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(actionBarDrawerToggle!!)
        actionBarDrawerToggle!!.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        binding.navigationView.setNavigationItemSelectedListener(this)


        val navController = findNavController(R.id.fragment)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)



    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.user ->  {
               val feedback = findViewById<NavigationMenuItemView>(R.id.user)
                feedback.setOnClickListener {
                    val intent = Intent(this, Feedback::class.java)
                    startActivity(intent)
                }
            }
            R.id.order ->  {
                Toast.makeText(this,"Your Order", Toast.LENGTH_SHORT).show()
            }
            R.id.seller ->  {
       //         Toast.makeText(this,"Become a seller", Toast.LENGTH_SHORT).show()
                val seller = findViewById<NavigationMenuItemView>(R.id.seller)
                seller.setOnClickListener {
                    val intent = Intent(this , Seller::class.java)
                    startActivity(intent)
                }
            }
            R.id.setting ->  {
//                Toast.makeText(this,"Settings", Toast.LENGTH_SHORT).show()
                val settings = findViewById<NavigationMenuItemView>(R.id.setting)
                settings.setOnClickListener{
                    val intent = Intent(this , Settings::class.java)
                    startActivity(intent)
                }
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (actionBarDrawerToggle!!.onOptionsItemSelected(item)) {
            true
        } else
            super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            binding.drawerLayout.close()
    }

}