package com.example.tour_guide_nepal.service.model

import com.example.tour_guide_nepal.service.response.NearByPlacesRespopnse


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MapModel
{


    @SerializedName("northeast")
    @Expose
    private var northeast: NearByPlacesRespopnse.Northeast? =
        null
    @SerializedName("southwest")
    @Expose
    private var southwest: NearByPlacesRespopnse.Southwest? =
        null

    fun getNortheast(): NearByPlacesRespopnse.Northeast? {
        return northeast
    }

    fun setNortheast(northeast: NearByPlacesRespopnse.Northeast?) {
        this.northeast = northeast
    }

    fun getSouthwest(): NearByPlacesRespopnse.Southwest? {
        return southwest
    }

    fun setSouthwest(southwest: NearByPlacesRespopnse.Southwest?) {
        this.southwest = southwest
    }


    class Distance {
        @SerializedName("text")
        @Expose
        var text: String? = null
        @SerializedName("value")
        @Expose
        var value: Int? = null

    }






}