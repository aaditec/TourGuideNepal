package com.example.tour_guide_nepal

import android.content.ContentValues.TAG
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotpassword.*


class forgotpassword_activity : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)


        mAuth = FirebaseAuth.getInstance()


        btn_submit.setOnClickListener {
            val email = et_forget_email.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                Toast.makeText(applicationContext, "Enter your email!", Toast.LENGTH_SHORT).show()
            } else {
                mAuth!!.sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            // successful!
                        } else {
                            // failed!
                        }
                    }
            }
        }
    }
}






