package com.example.tour_guide_nepal

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotpassword.*


class forgotpassword_activity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private lateinit var et_forget_email: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        et_forget_email = findViewById(R.id.et_forget_email)
        mAuth = FirebaseAuth.getInstance()



        btn_submit.setOnClickListener {
            FirebaseAuth.getInstance().sendPasswordResetEmail("user@example.com")
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG, "Email sent.")
                    }
                }
        }
    }
}






