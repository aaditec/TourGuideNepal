package com.example.tour_guide_nepal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tour_guide_nepal.Profile_Activity
import com.example.tour_guide_nepal.R


class ProfileFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        startActivity(Intent(activity,Profile_Activity::class.java))
        return inflater.inflate(R.layout.fragment_profile, container, false)

    }


}