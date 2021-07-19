package com.example.tour_guide_nepal.place_details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.models.SlideModel
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.maps.chitwan_map_activity
import com.example.tour_guide_nepal.maps.lumbini_map_activity
import com.example.tour_guide_nepal.weather.chitwan_weatherActivity
import com.example.tour_guide_nepal.weather.lumbini_weatherActivity

class lumbini_detail_activity : AppCompatActivity() {
    private lateinit var lumbinimap : ConstraintLayout
    private lateinit var lumbiniweather : ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lumbini_details)

        lumbinimap = findViewById(R.id.lumbinimap)
        lumbiniweather = findViewById(R.id.lumbiniweather)

        val imagelist = ArrayList<SlideModel>()

        imagelist.add(SlideModel("https://www.nepalsanctuarytreks.com/wp-content/uploads/2018/10/lumbini.jpg","Lumbini"))
        imagelist.add(SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQM2zlXBlV4xq9h1hN2WPSYWL7atu9PnIhSsS1fV81RGVWXD1W0","Lumbini"))
        imagelist.add(SlideModel("https://www.fascinatingnepal.com/wp-content/uploads/2016/12/1510868_1513761068953891_3514751366300006814_n.jpg","Lumbini"))

        val imageSlider = findViewById<ImageSlider>(R.id.lumbiniimage)
        imageSlider.setImageList(imagelist)


        lumbinimap.setOnClickListener {
            val intent = Intent(this, lumbini_map_activity::class.java)
            startActivity(intent)
        }
        lumbiniweather.setOnClickListener {
            val intent = Intent(this, lumbini_weatherActivity::class.java)
            startActivity(intent)
        }

    }
}