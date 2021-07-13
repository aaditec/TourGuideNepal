package com.example.tour_guide_nepal.maps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tour_guide_nepal.R
import com.example.tour_guide_nepal.databinding.ActivityMustangMapBinding

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class mustang_map_activity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val mustang = LatLng(28.9985065, 83.8473015)
        // Add a marker in mustang and move the camera
        mMap.addMarker(
            MarkerOptions().position(mustang)
                .title("mustang")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        )
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(mustang, 15F), 3000, null
        )
        //  mMap.moveCamera(CameraUpdateFactory.newLatLng(mustang))
        mMap.uiSettings.isZoomControlsEnabled = true
    }
}