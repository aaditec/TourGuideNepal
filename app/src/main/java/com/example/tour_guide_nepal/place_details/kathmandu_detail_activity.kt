package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.kathmandu_map_activity
import com.example.tour_guide_nepal.nearbyplaces.kathmandu_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.kathmandu_weatherActivity

class kathmandu_detail_activity : AppCompatActivity() {
    private lateinit var kathmandumap : ConstraintLayout
    private lateinit var kathmanduweather : ConstraintLayout
    private lateinit var kathmandunear : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kathmandu_detail)

        kathmandumap = findViewById(R.id.kathmandumap)
        kathmanduweather = findViewById(R.id.kathmanduweather)
        kathmandunear = findViewById(R.id.kathmandunear)

        kathmandumap.setOnClickListener {
            val intent = Intent(this, kathmandu_map_activity::class.java)
            startActivity(intent)
        }
        kathmanduweather.setOnClickListener {
            val intent = Intent(this, kathmandu_weatherActivity::class.java)
            startActivity(intent)
        }
        kathmandunear.setOnClickListener {
            val intent = Intent(this, kathmandu_nearbyplaces::class.java)
            startActivity(intent)
        }

    }
}