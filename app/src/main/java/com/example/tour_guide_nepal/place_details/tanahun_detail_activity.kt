package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.tanahun_map_activity
import com.example.tour_guide_nepal.weather.Tanahun_weatherActivity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity

class tanahun_detail_activity : AppCompatActivity() {
    private lateinit var tanahunmap : ConstraintLayout
    private lateinit var tanahunweather : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tanahun_detail)

        tanahunmap = findViewById(R.id.tanahunmap)
        tanahunweather = findViewById(R.id.tanahunweather)


        tanahunmap.setOnClickListener {
            val intent = Intent(this, tanahun_map_activity::class.java)
            startActivity(intent)
        }
        tanahunweather.setOnClickListener {
            val intent = Intent(this, Tanahun_weatherActivity::class.java)
            startActivity(intent)
        }

    }
}