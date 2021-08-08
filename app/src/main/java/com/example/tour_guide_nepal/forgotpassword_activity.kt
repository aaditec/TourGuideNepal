package com.example.tour_guide_nepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgotpassword.*

class forgotpassword_activity : AppCompatActivity() {
    private var firebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)

        firebaseAuth = FirebaseAuth.getInstance()
        btn_submit.setOnClickListener {
            reset()
        }
    }

    fun reset() {
        var emailR = et_forget_email.text.toString()
        if (emailR.isEmpty()) {
            Toast.makeText(this, "please Enter Your Email", Toast.LENGTH_SHORT).show()
        }
        firebaseAuth?.sendPasswordResetEmail(emailR)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Toast.makeText(this, "reset email sent", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "reset email not sent", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


