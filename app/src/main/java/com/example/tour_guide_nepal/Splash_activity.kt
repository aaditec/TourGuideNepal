package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash_activity : AppCompatActivity() {

    private val splashScreentimeout: Long = 1500

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({

            startActivity(Intent(this,LoginActivity::class.java))
            finish()

        },splashScreentimeout)
    }
}