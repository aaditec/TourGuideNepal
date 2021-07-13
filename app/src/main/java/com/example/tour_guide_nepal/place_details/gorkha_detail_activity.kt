package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.gorkha_map_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.gorkha_weatherActivity

class gorkha_detail_activity : AppCompatActivity() {

    private lateinit var gorkhamap : ConstraintLayout
    private lateinit var gorkhaweather : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gorkha_detail)

        gorkhamap = findViewById(R.id.gorkhamap)
        gorkhaweather = findViewById(R.id.gorkhaweather)


        gorkhamap.setOnClickListener {
            val intent = Intent(this, gorkha_map_activity::class.java)
            startActivity(intent)
        }
        gorkhaweather.setOnClickListener {
            val intent = Intent(this, gorkha_weatherActivity::class.java)
            startActivity(intent)
        }

    }
}