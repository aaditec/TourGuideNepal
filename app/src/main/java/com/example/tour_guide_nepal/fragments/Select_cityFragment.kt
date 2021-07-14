package com.example.tour_guide_nepal.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.place_details.*


class Select_cityFragment : Fragment() {
    private lateinit var kathmandu : LinearLayout
    private lateinit var chitwan : LinearLayout
    private lateinit var dolakha : LinearLayout
    private lateinit var gorkha : LinearLayout
    private lateinit var janakpur : LinearLayout
    private lateinit var lumbini : LinearLayout
    private lateinit var mustang : LinearLayout
    private lateinit var pokhara : LinearLayout
    private lateinit var solukhumbu : LinearLayout
    private lateinit var tanahun : LinearLayout


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
        chitwan = view.findViewById(R.id.chitwan)
        janakpur = view.findViewById(R.id.janakpur)
        dolakha = view.findViewById(R.id.dolakha)
        pokhara = view.findViewById(R.id.pokhara)
        solukhumbu = view.findViewById(R.id.solukhumbu)
        lumbini = view.findViewById(R.id.lumbini)
        mustang = view.findViewById(R.id.mustang)
        tanahun = view.findViewById(R.id.tanahun)
        gorkha = view.findViewById(R.id.gorkha)

    kathmandu.setOnClickListener {
    startActivity(Intent(activity, kathmandu_detail_activity::class.java))
    }
        dolakha.setOnClickListener {
            startActivity(Intent(activity, dolakha_detail_activity::class.java))
        }
        chitwan.setOnClickListener {
            startActivity(Intent(activity, chitwan_detail_activity::class.java))
        }
        gorkha.setOnClickListener {
            startActivity(Intent(activity, gorkha_detail_activity::class.java))
        }
        janakpur.setOnClickListener {
            startActivity(Intent(activity, janakpur_detail_activity::class.java))
        }
        lumbini.setOnClickListener {
            startActivity(Intent(activity, lumbini_detail_activity::class.java))
        }
        mustang.setOnClickListener {
            startActivity(Intent(activity, mustang_detail_activity::class.java))
        }
        pokhara.setOnClickListener {
            startActivity(Intent(activity, pokhara_detail_activity::class.java))
        }
        solukhumbu.setOnClickListener {
            startActivity(Intent(activity, solukhumbu_detail_activity::class.java))
        }
        tanahun.setOnClickListener {
            startActivity(Intent(activity, tanahun_detail_activity::class.java))
        }
       return view
    }



}