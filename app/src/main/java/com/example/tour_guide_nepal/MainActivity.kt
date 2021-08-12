package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.tour_guide_nepal.adapter.ViewPagerAdapter
import com.example.tour_guide_nepal.fragments.AboutUsFragment
import com.example.tour_guide_nepal.fragments.ProfileFragment
import com.example.tour_guide_nepal.fragments.Select_cityFragment
import com.example.tour_guide_nepal.fragments.Selectplaces
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var lstTitle: ArrayList<String>
    private lateinit var lstFragments: ArrayList<Fragment>
    private lateinit var viewpager2: ViewPager2
    private lateinit var tablayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewpager2 = findViewById(R.id.viewpager)
        tablayout = findViewById(R.id.tablayout)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer)
        val navView: NavigationView = findViewById(R.id.navmenu)

        populateList()
        val adapter = ViewPagerAdapter(lstFragments, supportFragmentManager, lifecycle)
        viewpager2.adapter = adapter
        TabLayoutMediator(tablayout, viewpager2) { tab, position ->
            tab.text = lstTitle[position]
        }.attach()

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                }

                R.id.nav_select_city -> {
                    startActivity(Intent(this, Selectplaces::class.java))
                }
                R.id.nav_bookhotel -> {
                    startActivity(Intent(this, Hotelbooking_Activity::class.java))
                }
                R.id.nav_viewbookhotel -> {
                    startActivity(Intent(this, HotelBookingInfo::class.java))
                }
                R.id.nav_contact -> {
                    Toast.makeText(
                        applicationContext,
                        "Emergency Contact Clicked",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.nav_terms -> {
                    startActivity(Intent(this,Profile_Activity::class.java))
                }
                R.id.nav_rateapp -> Toast.makeText(
                    applicationContext,
                    "Rate App Clicked",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_logout -> Toast.makeText(
                    applicationContext,
                    "Logout Clicked",
                    Toast.LENGTH_SHORT
                ).show()
            }

            true

        }
    }

    private fun populateList() {
        lstTitle = ArrayList<String>()
        lstTitle.add("Home")
        lstTitle.add("Profile")
        lstTitle.add("About Us")
        lstFragments = ArrayList<Fragment>()
        lstFragments.add(Select_cityFragment())
        lstFragments.add(ProfileFragment())
        lstFragments.add(AboutUsFragment())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {

            return true
        }

        return super.onOptionsItemSelected(item)
    }
}