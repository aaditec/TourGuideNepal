package com.example.tour_guide_nepal

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tour_guide_nepal.API.ServiceBuilder
import com.example.tour_guide_nepal.Repository.UserRepository
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LoginActivity : AppCompatActivity() {
    private lateinit var btnlogin: Button
    private lateinit var linkregister: TextView
    private lateinit var txtname: TextView
    private lateinit var txtpass: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var forgotpass: TextView
    private lateinit var google: ImageView


    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnlogin = findViewById(R.id.btnlogin)
        linkregister = findViewById(R.id.linkregister)
        txtname = findViewById(R.id.txtname)
        txtpass = findViewById(R.id.txtpass)
        forgotpass = findViewById(R.id.forgotpass)
        google= findViewById(R.id.google)

        auth = FirebaseAuth.getInstance()



        google.setOnClickListener {

        }
        forgotpass.setOnClickListener {

            val intent = Intent(this, forgotpassword_activity::class.java)
            startActivity(intent)
        }
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
            val email = txtname.text.toString()
            val password = txtpass.text.toString()
            auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, OnCompleteListener { task ->
                if(task.isSuccessful) {
                    Toast.makeText(this, "Successfully Logged In", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            })
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val repository = UserRepository()
                    val response = repository.loginUser(email, password)
                    if (response.success == true) {
                        ServiceBuilder.token = "Bearer " + response.token
                        startActivity(
                            Intent(
                                this@LoginActivity,
                                MainActivity::class.java
                            )

                        )
                        finish()
                    } else {
                        withContext(Dispatchers.Main) {
                            val snack =
                                Snackbar.make(
                                    linearLayout,
                                    "Invalid credentials",
                                    Snackbar.LENGTH_LONG
                                )
                            snack.setAction("OK", View.OnClickListener {
                                snack.dismiss()
                            })
                            snack.show()
                        }
                    }

                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                            this@LoginActivity,
                            ex.message, Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

        }

    }

    private fun sanitize(input: EditText): String {
        return input.text.toString().trim(' ')
    }

    private fun validateLogin(): Boolean {
        var valid = true
        txtname.error = null
        txtpass.error = null

        if (sanitize(txtname as EditText).isEmpty()) {
            txtname.error = "email can not be empty"
            valid = false
        }
        if (sanitize(txtpass as EditText).isEmpty()) {
            txtpass.error = "Password can not be empty"
            valid = false
        }

        return valid
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        updateUI(currentUser)
    }

    fun updateUI(currentUser: FirebaseUser?) {

    }

    }


