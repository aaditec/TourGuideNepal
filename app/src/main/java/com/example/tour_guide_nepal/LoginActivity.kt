package com.example.tour_guide_nepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var upass: EditText
    private lateinit var btnlogin: Button
    private lateinit var btngoogle: Button
    private lateinit var signup: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        uname=findViewById(R.id.uname)
        upass=findViewById(R.id.upass)
        btnlogin=findViewById(R.id.btnlogin)
        btngoogle=findViewById(R.id.btngoogle)
        signup=findViewById(R.id.signup)

        btnlogin.setOnClickListener {
            login()
        }
    }

    private fun login() {

    }
}