package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.dolakha_map_activity
import com.example.tour_guide_nepal.nearbyplaces.dolakha_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity

class dolakha_detail_activity : AppCompatActivity() {
    private lateinit var dolokhamap : ConstraintLayout
    private lateinit var dolokhaweather : ConstraintLayout
    private lateinit var dolakhanear : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dolakha_detail)

        dolokhamap = findViewById(R.id.dolakhamap)
        dolokhaweather = findViewById(R.id.dolakhaweather)
        dolakhanear = findViewById(R.id.dolakhanear)


        dolokhamap.setOnClickListener {
            val intent = Intent(this, dolakha_map_activity::class.java)
            startActivity(intent)
        }
        dolokhaweather.setOnClickListener {
            val intent = Intent(this, dolakha_weatherActivity::class.java)
            startActivity(intent)
        }
        dolakhanear.setOnClickListener {
            val intent = Intent(this, dolakha_nearbyplaces::class.java)
            startActivity(intent)
        }

    }
}