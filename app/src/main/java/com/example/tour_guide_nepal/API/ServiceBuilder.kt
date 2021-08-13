package com.example.tour_guide_nepal.API

import android.R
import android.net.wifi.WifiConfiguration.AuthAlgorithm.strings
import android.net.wifi.WifiConfiguration.GroupCipher.strings
import android.net.wifi.WifiConfiguration.KeyMgmt.strings
import android.provider.Settings.Global.getString
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {
//    private const val BASE_URL = "http://10.0.2.2:90/"
// private const val BASE_URL = "http://192.168.43.204:90/"
     private const val BASE_URL = "http://192.168.43.188:90/"




    var token:String?=null
    private val okhttp =
        OkHttpClient.Builder()

    // Configure Google Sign In
    var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken("528198962031-7825tjipd7d4hsjls9akv32e03k3l3dg.apps.googleusercontent.com")
        .requestEmail()
        .build()
    //create retrofit builder
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttp.build())

    //Create retrofit instance
    private val retrofit = retrofitBuilder.build()
    //Generic function
    fun <T> buildService(serviceType: Class<T>):T{
        return retrofit.create(serviceType)
    }
    fun loadImagePath(): String {
        val arr = BASE_URL.split("/").toTypedArray()
        return arr[0] + "/" + arr[1] + arr[2] + "/"
    }
}