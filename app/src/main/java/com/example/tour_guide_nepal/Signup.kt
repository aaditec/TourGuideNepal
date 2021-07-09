package com.example.tour_guide_nepal

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
    private  lateinit var register1: Button
    private lateinit var txtusername: TextView
    private lateinit var txtfullname: TextView
    private lateinit var txtnewphone: TextView
    private lateinit var etpass: TextView
    private lateinit var etconfigpass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        txtfullname = findViewById(R.id.txtusername)
        txtfullname = findViewById(R.id.txtfullname)
        etpass = findViewById(R.id.etpass)
        etconfigpass = findViewById(R.id.etconpass)
        txtnewphone = findViewById(R.id.txtnewphone)
        register1 = findViewById(R.id.btnregister1)

        register1.setOnClickListener {
            signup()
        }

    }
    private fun signup() {
        register1.setOnClickListener {
        if (validatesignup()) {
            val FullName = txtfullname.text.toString()
            val usernme = txtusername.text.toString()
            val phonenumber = txtnewphone.text.toString()
            val password = etpass.text.toString()
            val confirmPassword = etconfigpass.text.toString()

            if (password != confirmPassword) {
                etpass.error = "Password does not match"
                etpass.requestFocus()
                return@setOnClickListener
            } else {
                val user =
                    User(fullname = FullName, username = usernme, phone_number = phonenumber, password = password)

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
    }
//        register.setOnClickListener {
//            val intent = Intent(this, login_form::class.java)
//            startActivity(intent)
//            val myToast = Toast.makeText(applicationContext,"Sign_up successfully",Toast.LENGTH_SHORT)
//
//            myToast.show()
//        }
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
        txtnewphone.error = null

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
        if (sanitize(txtnewphone as EditText).isEmpty()) {
            txtnewphone.error = "phone number can not be empty"
            valid = false
        }


        return valid
    }


}
