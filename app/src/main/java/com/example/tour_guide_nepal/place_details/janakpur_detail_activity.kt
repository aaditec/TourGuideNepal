package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.janakpur1_map
import com.example.tour_guide_nepal.nearbyplaces.janakpur_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.janakpur_weatherActivity

class janakpur_detail_activity : AppCompatActivity() {
    private lateinit var janakpurmap : ConstraintLayout
    private lateinit var janakpurweather : ConstraintLayout
    private lateinit var janakpurnear : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_janakpur_detail)

        janakpurmap = findViewById(R.id.janakpurmap)
        janakpurweather = findViewById(R.id.janakpurweather)
        janakpurnear = findViewById(R.id.janakpurnear)

        janakpurmap.setOnClickListener {
            val intent = Intent(this, janakpur1_map::class.java)
            startActivity(intent)
        }
        janakpurweather.setOnClickListener {
            val intent = Intent(this, janakpur_weatherActivity::class.java)
            startActivity(intent)
        }
        janakpurnear.setOnClickListener {
            val intent = Intent(this, janakpur_nearbyplaces::class.java)
            startActivity(intent)
        }
    }
}