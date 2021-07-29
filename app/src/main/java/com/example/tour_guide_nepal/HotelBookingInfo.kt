package com.example.tour_guide_nepal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.Repository.HotelBookRepository
import com.example.tour_guide_nepal.adapter.HotelBookViewAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HotelBookingInfo : AppCompatActivity(), HotelBookViewAdapter.onItemClickListener {
    private lateinit var recyclerview: RecyclerView
    private lateinit var swipeRefresh: SwipeRefreshLayout
    private lateinit var lstHotelBookView:MutableList<HotelBookDetails>
    private lateinit var myAdapter : HotelBookViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_booking_info)

        recyclerview = findViewById(R.id.recyclerview)
        swipeRefresh = findViewById(R.id.swiperefresh)

        refreshapp()

        loadbookingdetails()
    }

    private fun loadbookingdetails() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val hotelBookDetails = HotelBookDetails()
                val hotelBookRepository = HotelBookRepository()
                val response = hotelBookRepository.getallBookHotel(hotelBookDetails._id!!)
                if (response.data != null) {

                    val lstBookDetails = response.data
                    withContext(Dispatchers.Main) {


                        recyclerview.adapter =
                            HotelBookViewAdapter(this@HotelBookingInfo, lstBookDetails!!)

                        recyclerview.layoutManager =
                            LinearLayoutManager(this@HotelBookingInfo)

                    }
                }
            } catch (ex: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(
                        this@HotelBookingInfo,
                        "Error : ${ex.toString()}", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun refreshapp() {
        swipeRefresh.setOnRefreshListener {
            loadbookingdetails()

            swipeRefresh.isRefreshing = false
            Toast.makeText(this, "refreshed", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onItemClick(position: Int) {
        //Toast.makeText(this, "onclick $position", Toast.LENGTH_LONG).show()
        val intent = Intent(this,HotelBookingDetailedInfoActivity::class.java)
        intent.putExtra("hotelbookinfo",lstHotelBookView[position])
        startActivity(intent)
    }
}