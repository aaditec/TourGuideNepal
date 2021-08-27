package com.example.tour_guide_nepal.termsandservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.tour_guide_nepal.LoginActivity
import com.example.tour_guide_nepal.R
import org.jetbrains.anko.find

class front_terms_and_services : AppCompatActivity() {
    private lateinit var backlogin: Button
    private lateinit var termspage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front_terms_and_services)

        backlogin = findViewById(R.id.backlogin)
        termspage = findViewById(R.id.termspage)

        backlogin.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java)) }

        termspage.setOnClickListener {
        startActivity(Intent(this, termsandconditions::class.java))}

    }
}