package com.example.tour_guide_nepal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.place_details.kathmandu_detail_activity


class Select_cityFragment : Fragment() {
    private lateinit var kathmandu : LinearLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_select_city, container, false)

        kathmandu = view.findViewById(R.id.kathmandu)
    kathmandu.setOnClickListener {
    startActivity(Intent(activity, kathmandu_detail_activity::class.java))
    }
       return view
    }



}