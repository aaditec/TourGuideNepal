package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tour_guide_nepal.ENTITY.User
import com.example.tour_guide_nepal.Repository.UserRepository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Signup : AppCompatActivity() {
    private  lateinit var btnsignup: Button
    private lateinit var auth: FirebaseAuth


    private lateinit var etname: TextView
    private lateinit var etphone: TextView
    private lateinit var etpass: TextView
    private lateinit var etconfigpass: TextView
    private lateinit var etemail: TextView
    private lateinit var btnlog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        auth = FirebaseAuth.getInstance()
        etname = findViewById(R.id.etname)
        etemail = findViewById(R.id.etemail)
        etpass = findViewById(R.id.etpass)
        etconfigpass = findViewById(R.id.etconpass)
        etphone = findViewById(R.id.etphone)
        btnsignup = findViewById(R.id.btnsignup)
        btnlog = findViewById(R.id.btnlog)


        btnsignup.setOnClickListener {

            if (validatesignup()) {

                val FullName = etname.text.toString()
               val email = etemail.text.toString()
                val phone = etphone.text.toString()
                val password = etpass.text.toString()
                val confirmPassword = etconfigpass.text.toString()
                if (etemail.text.toString().isEmpty()) {
                    etemail.error = "Please enter email"
                    etemail.requestFocus()

                }

                if (!Patterns.EMAIL_ADDRESS.matcher(etemail.text.toString()).matches()) {
                    etemail.error = "Please enter valid email"
                    etemail.requestFocus()

                }
                if (etphone.text.toString().isEmpty()) {
                    etphone.error = "Please enter phone number"
                    etphone.requestFocus()

                }
                if (etname.text.toString().isEmpty()) {
                    etname.error = "Please enter your full name"
                    etname.requestFocus()

                }

                if (etpass.text.toString().isEmpty()) {
                    etpass.error = "Please enter password"
                    etpass.requestFocus()

                }
                if (password != confirmPassword) {
                    etpass.error = "Password does not match"
                    etpass.requestFocus()
                    return@setOnClickListener
                } else {
                    val user =
                        User(

                            fullname = FullName,
                            email = email,
                            phone = phone,
                            password = password
                        )

                    auth.createUserWithEmailAndPassword(etemail.text.toString(), etpass.text.toString() )
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                startActivity(Intent(this,LoginActivity::class.java))
                                finish()
                            } else {
                                Toast.makeText(baseContext, "Sign Up failed. Try again after some time.",
                                    Toast.LENGTH_SHORT).show()
                            }
                        }
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            val userRepository = UserRepository()
                            val response = userRepository.registerUser(user)
                            if (response.success == true) {
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(
                                        this@Signup,
                                        "signup successfully", Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                        } catch (ex: Exception) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    this@Signup,
                                    ex.message, Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }



                }

            }


            btnlog.setOnClickListener {

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

        }

    }




    private fun sanitize(input : EditText) : String{
        return input.text.toString().trim(' ')
    }


    private fun validatesignup(): Boolean {

            var valid = true
            etemail.error = null
            etname.error = null
            etpass.error = null
            etconfigpass.error = null
            etphone.error = null


        if (sanitize(etemail as EditText).isEmpty()) {
            etemail.error = "Email can not be empty"
            valid = false
        }


            if (sanitize(etname as EditText).isEmpty()) {
                etname.error = "Fullname can not be empty"
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
            if (sanitize(etphone as EditText).isEmpty()) {
                etphone.error = "phone number can not be empty"
                valid = false
            }


            return valid
    }


}
