package com.example.tour_guide_nepal.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.tour_guide_nepal.service.repository.NearByPlacesRepository
import com.example.tour_guide_nepal.service.response.NearByPlacesRespopnse
import retrofit2.adapter.rxjava2.Result.response
import java.nio.channels.spi.AbstractSelectionKey

class NearByPlacesViewModel(application: Application): AndroidViewModel(application)
{
    fun getNearByPlacs(location:String?,radious: String,keyword: String,key: String):LiveData<NearByPlacesRespopnse>
    {

        return NearByPlacesRepository.getInstance().getNearByPlacesList(location,radious,keyword,key)
    }
}