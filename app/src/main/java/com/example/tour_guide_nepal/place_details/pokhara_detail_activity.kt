package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.pokhara_map_activity
import com.example.tour_guide_nepal.nearbyplaces.pokhara_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.pokhara_weatherActivity

class pokhara_detail_activity : AppCompatActivity() {
    private lateinit var pokharamap : ConstraintLayout
    private lateinit var pokharaweather : ConstraintLayout
    private lateinit var pokharanear : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokhara_detail)

        pokharamap = findViewById(R.id.pokharamap)
        pokharaweather = findViewById(R.id.pokharaweather)
        pokharanear = findViewById(R.id.pokharanear)

        pokharamap.setOnClickListener {
            val intent = Intent(this, pokhara_map_activity::class.java)
            startActivity(intent)
        }
        pokharaweather.setOnClickListener {
            val intent = Intent(this, pokhara_weatherActivity::class.java)
            startActivity(intent)
        }
        pokharanear.setOnClickListener {
            val intent = Intent(this, pokhara_nearbyplaces::class.java)
            startActivity(intent)
        }
    }
}