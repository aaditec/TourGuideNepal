package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.mustang_map_activity
import com.example.tour_guide_nepal.nearbyplaces.mustang_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.mustang_weatherActivity

class mustang_detail_activity : AppCompatActivity() {
    private lateinit var mustangmap : ConstraintLayout
    private lateinit var mustangweather : ConstraintLayout
    private lateinit var mustangnear : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mustang_detail)

        mustangmap = findViewById(R.id.mustangmap)
        mustangweather = findViewById(R.id.mustangweather)
        mustangnear = findViewById(R.id.mustangnear)


        mustangmap.setOnClickListener {
            val intent = Intent(this, mustang_map_activity::class.java)
            startActivity(intent)
        }
        mustangweather.setOnClickListener {
            val intent = Intent(this, mustang_weatherActivity::class.java)
            startActivity(intent)
        }
        mustangnear.setOnClickListener {
            val intent = Intent(this, mustang_nearbyplaces::class.java)
            startActivity(intent)
        }
    }
}