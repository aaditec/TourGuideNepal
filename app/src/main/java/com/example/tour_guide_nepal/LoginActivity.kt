package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private lateinit var btnlogin: Button
    private lateinit var linkregister: TextView
    private lateinit var txtname: TextView
    private lateinit var txtpass: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin = findViewById(R.id.btnlogin)
        linkregister = findViewById(R.id.linkregister)
        txtname = findViewById(R.id.txtname)
        txtpass = findViewById(R.id.txtpass)

        btnlogin.setOnClickListener {
            login()

        }
        linkregister.setOnClickListener {

            val intent = Intent(this, Signup::class.java)
            startActivity(intent)
        }

    }



    private fun login() {
        if (validateLogin()) {

    }

}
    private fun sanitize(input : EditText) : String{
        return input.text.toString().trim(' ')
    }
    private fun validateLogin(): Boolean {
        var valid = true
        txtname.error = null
        txtpass.error = null

        if (sanitize(txtname as EditText).isEmpty()) {
            txtname.error = "Username can not be empty"
            valid = false
        }
        if (sanitize(txtpass as EditText).isEmpty()) {
            txtpass.error = "Password can not be empty"
            valid = false
        }

        return valid
    }

    }


