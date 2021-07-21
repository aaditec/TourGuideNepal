package com.example.tour_guide_nepal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.jetbrains.anko.toast

class Hotelbooking_Activity : AppCompatActivity() {
    private lateinit var etfullname: EditText
    private lateinit var etemail: EditText
    private lateinit var etphonenumber: EditText
    private lateinit var etguestnumber: EditText
    private lateinit var btnbook: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotelbooking)

        etfullname = findViewById(R.id.etfullname)
        etemail = findViewById(R.id.etemail)
        etphonenumber = findViewById(R.id.etphonenumber)
        etguestnumber = findViewById(R.id.etguestnumber)
        btnbook = findViewById(R.id.btnbook)

        btnbook.setOnClickListener {
            hotelBook()
        }
    }

    private fun hotelBook() {
        val fullname = etfullname.text.toString()
        val email = etemail.text.toString()
        val phnumber = etphonenumber.text.toString()
        val guestno = etguestnumber.text.toString()

        val hotelBookDetails = HotelBookDetails(
            fullname = fullname,
            email = email,
            phnumber = phnumber,
            guestno = guestno
        )
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val hotelBookRepository = HotelBookRepository()
                val response = hotelBookRepository.bookHotel(hotelBookDetails)

                if (response.success ==true){
                    withContext(Dispatchers.Main){
                        Toast.makeText(this@Hotelbooking_Activity,
                        "Hotel Booked Successfully",
                        Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@Hotelbooking_Activity,
                        "Error ${ex.localizedMessage}",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }
        }
    }
}