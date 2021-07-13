package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity

class chitwan_detail_activity : AppCompatActivity() {
    private lateinit var chitwanmap : ConstraintLayout
    private lateinit var chitwanweather : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chitwan_detail)

        chitwanmap = findViewById(R.id.chitwanmap)
        chitwanweather = findViewById(R.id.chitwanweather)


        chitwanmap.setOnClickListener {
            val intent = Intent(this, chitwan_map_activity::class.java)
            startActivity(intent)
        }
        chitwanweather.setOnClickListener {
            val intent = Intent(this, chitwan_weatherActivity::class.java)
            startActivity(intent)
        }

    }
}