package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.lumbini_map_activity
import com.example.tour_guide_nepal.nearbyplaces.lumbini_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.lumbini_weatherActivity

class lumbini_detail_activity : AppCompatActivity() {
    private lateinit var lumbinimap : ConstraintLayout
    private lateinit var lumbiniweather : ConstraintLayout
    private lateinit var lumbininear : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lumbini_details)

        lumbinimap = findViewById(R.id.lumbinimap)
        lumbiniweather = findViewById(R.id.lumbiniweather)
        lumbininear = findViewById(R.id.lumbininear)

        lumbinimap.setOnClickListener {
            val intent = Intent(this, lumbini_map_activity::class.java)
            startActivity(intent)
        }
        lumbiniweather.setOnClickListener {
            val intent = Intent(this, lumbini_weatherActivity::class.java)
            startActivity(intent)
        }
        lumbininear.setOnClickListener {
            val intent = Intent(this, lumbini_nearbyplaces::class.java)
            startActivity(intent)
        }

    }
}