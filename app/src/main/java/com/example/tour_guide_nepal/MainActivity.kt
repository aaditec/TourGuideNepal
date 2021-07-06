package com.example.tour_guide_nepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout :DrawerLayout = findViewById(R.id.drawer)
        val navView : NavigationView = findViewById(R.id.navmenu)

        toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> Toast.makeText(applicationContext, "Home Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_select_city -> Toast.makeText(applicationContext, "Select City Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_profile -> Toast.makeText(applicationContext, "Profile Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_aboutus -> Toast.makeText(applicationContext, "About Us Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_contact -> Toast.makeText(applicationContext, "Emergency Contact Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_terms -> Toast.makeText(applicationContext, "Terms and Services Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_rateapp -> Toast.makeText(applicationContext, "Rate App Clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_logout -> Toast.makeText(applicationContext, "Logout Clicked", Toast.LENGTH_SHORT).show()
            }

            true

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}