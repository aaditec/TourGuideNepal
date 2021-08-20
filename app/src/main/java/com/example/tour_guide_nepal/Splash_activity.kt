package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView


class Splash_activity : AppCompatActivity() {

    val SPLASH_SCREEN = 3000

    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation

    private lateinit var centerlogo: ImageView
    private lateinit var word1: TextView
    private lateinit var btnstarted: Button
    private lateinit var travelvehicle: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        btnstarted = findViewById(R.id.btnstarted)
        travelvehicle = findViewById(R.id.travelvehicle)

//hide status bar
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val actionBar = supportActionBar
        actionBar!!.hide()

//        val sharedPref = getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
//        if (sharedPref.contains("username") && sharedPref.contains("password")) {
            Handler().postDelayed({
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }, SPLASH_SCREEN.toLong())
//        }
//        else {
//            btnstarted.visibility = View.VISIBLE
//            btnstarted.setOnClickListener {
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//            }
//        }

        //creating two animations
        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bot_animation)

        centerlogo = findViewById(R.id.centerlogo)
        word1 = findViewById(R.id.word1)


        word1.animation = topAnimation
        centerlogo.animation = topAnimation
        travelvehicle.animation = bottomAnimation

    }
}