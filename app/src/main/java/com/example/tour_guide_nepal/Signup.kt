package com.example.tour_guide_nepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView



class Signup : AppCompatActivity() {
    private  lateinit var register1: Button
    private lateinit var txtusername: TextView
    private lateinit var txtfullname: TextView
    private lateinit var etpass: TextView
    private lateinit var etconfigpass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        txtfullname = findViewById(R.id.txtfullname)
        etpass = findViewById(R.id.etpass)
        etconfigpass = findViewById(R.id.etconpass)

        register1.setOnClickListener {
            signup()
        }

    }
    private fun signup() {
        if (validatesignup()) {

        }

    }
    private fun sanitize(input : EditText) : String{
        return input.text.toString().trim(' ')
    }
    private fun validatesignup(): Boolean {
        var valid = true
        txtusername.error = null
        txtfullname.error = null
        etpass.error = null
        etconfigpass.error = null

        if (sanitize(txtusername as EditText).isEmpty()) {
            txtusername.error = "Username can not be empty"
            valid = false
        }
        if (sanitize(txtfullname as EditText).isEmpty()) {
            txtfullname.error = "Fullname can not be empty"
            valid = false
        }
        if (sanitize(etpass as EditText).isEmpty()) {
            etpass.error = "Password can not be empty"
            valid = false
        }
        if (sanitize(etconfigpass as EditText).isEmpty()) {
            etconfigpass.error = "confirm Password can not be empty"
            valid = false
        }

        return valid
    }


}