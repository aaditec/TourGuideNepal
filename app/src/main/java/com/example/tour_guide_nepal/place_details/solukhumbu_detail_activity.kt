package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.solukhumbu_map_activity
import com.example.tour_guide_nepal.nearbyplaces.solukhumbu_nearbyplaces
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.dolakha_weatherActivity
import com.example.tour_guide_nepal.weather.solukhumbhu_weatherActivity

class solukhumbu_detail_activity : AppCompatActivity() {
    private lateinit var solukhumbumap : ConstraintLayout
    private lateinit var solukhumbuweather : ConstraintLayout
    private lateinit var solukhumbunear : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solukhumbu_detail)

        solukhumbumap = findViewById(R.id.solukhumbumap)
        solukhumbuweather = findViewById(R.id.solukhumbuweather)
        solukhumbunear = findViewById(R.id.solukhumbunear)

        solukhumbumap.setOnClickListener {
            val intent = Intent(this, solukhumbu_map_activity::class.java)
            startActivity(intent)
        }
        solukhumbuweather.setOnClickListener {
            val intent = Intent(this, solukhumbhu_weatherActivity::class.java)
            startActivity(intent)
        }
        solukhumbunear.setOnClickListener {
            val intent = Intent(this, solukhumbu_nearbyplaces::class.java)
            startActivity(intent)
        }
    }
}