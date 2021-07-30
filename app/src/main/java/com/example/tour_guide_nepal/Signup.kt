package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.finalassignment.ENTITY.User
import com.example.finalassignment.Repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class Signup : AppCompatActivity() {
    private  lateinit var btnsignup: Button
   // private lateinit var etuser: TextView
    private lateinit var etname: TextView
    private lateinit var etphone: TextView
    private lateinit var etpass: TextView
    private lateinit var etconfigpass: TextView
    private lateinit var etemail: TextView
    private lateinit var btnlog: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
       // etuser = findViewById(R.id.etuser)
        etname = findViewById(R.id.etname)
        etpass = findViewById(R.id.etpass)
        etconfigpass = findViewById(R.id.etconpass)
        etphone = findViewById(R.id.etphone)
        btnsignup = findViewById(R.id.btnsignup)
        etemail = findViewById(R.id.etemail)
        btnlog = findViewById(R.id.btnlog)


        btnsignup.setOnClickListener {
            if (validatesignup()) {
                val Email = etemail.text.toString()
                val FullName = etname.text.toString()
                //val username = etuser.text.toString()
                val phone = etphone.text.toString()
                val password = etpass.text.toString()
                val confirmPassword = etconfigpass.text.toString()
                if (password != confirmPassword) {
                    etpass.error = "Password does not match"
                    etpass.requestFocus()
                    return@setOnClickListener
                } else {
                    val user =
                        User(
                            email = Email,
                            fullname = FullName,
                           // username = username,
                            phone = phone,
                            password = password
                        )
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
           // etuser.error = null
            etname.error = null
            etpass.error = null
            etconfigpass.error = null
            etphone.error = null

        if (sanitize(etemail as EditText).isEmpty()) {
            etemail.error = "Email can not be empty"
            valid = false
        }
          //  if (sanitize(etuser as EditText).isEmpty()) {
            //    etuser.error = "Username can not be empty"
            //    valid = false
          //  }
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
