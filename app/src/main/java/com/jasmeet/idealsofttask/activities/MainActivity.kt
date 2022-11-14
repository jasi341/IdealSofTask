package com.jasmeet.idealsofttask.activities

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.jasmeet.idealsofttask.R
import com.jasmeet.idealsofttask.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    var actionBarDrawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBarDrawerToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle!!)

        actionBarDrawerToggle!!.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navView.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.Favourites -> {
                Toast.makeText(this, "Favourites", Toast.LENGTH_SHORT).show()
            }
            R.id.rateUs -> {
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show()
            }
            R.id.ShareApp-> {
                Toast.makeText(this, "Share App", Toast.LENGTH_SHORT).show()
            }
            R.id.AboutUs -> {
                Toast.makeText(this, "About Us", Toast.LENGTH_SHORT).show()
            }
            R.id.feedback -> {
                Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show()
            }
        }
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if(actionBarDrawerToggle!!.onOptionsItemSelected(item)){
            true
        }
        else {
            super.onOptionsItemSelected(item)
        }
    }


    override fun onBackPressed() {
        super.onBackPressed()
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.close()
        }
    }

}