package com.example.tour_guide_nepal.termsandservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tour_guide_nepal.R
import com.google.android.material.button.MaterialButton

class back_terms_and_services : AppCompatActivity() {
    private lateinit var backterms: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_terms_and_services)

       backterms=findViewById(R.id.backterms)

        startActivity(Intent(this@back_terms_and_services,termsandconditions::class.java))
    }
}