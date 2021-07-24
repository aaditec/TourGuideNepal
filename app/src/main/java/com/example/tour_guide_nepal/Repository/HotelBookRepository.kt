package com.example.tour_guide_nepal.Repository

import com.example.finalassignment.API.MyApiRequest
import com.example.finalassignment.API.ServiceBuilder
import com.example.tour_guide_nepal.ENTITY.HotelBookDetails
import com.example.tour_guide_nepal.Response.BookHotelResponse
import com.example.tour_guide_nepal.Response.DeleteBookHotelResponse
import com.example.tour_guide_nepal.Response.GetAllBookHotelResponse
import com.example.tour_guide_nepal.Response.UpdateBookHotelResponse

class HotelBookRepository : MyApiRequest() {
    private val HotelBookAPI =
        ServiceBuilder.buildService(com.example.tour_guide_nepal.API.HotelBookAPI::class.java)

    //Book Hotel
    suspend fun bookHotel(hotelBookDetails: HotelBookDetails): BookHotelResponse{
        return apiRequest {
            HotelBookAPI.bookHotel(
                ServiceBuilder.token!!,hotelBookDetails
            )
        }
    }

    //update bookHotel
    suspend fun updateBookHotel(id: String,hotelBookDetails: HotelBookDetails):UpdateBookHotelResponse{
        return apiRequest {
            HotelBookAPI.updateBookHotel(
                ServiceBuilder.token!!,id,hotelBookDetails
            )
        }
    }

    //Delete bookHotel
    suspend fun deletebookHotel(id: String):DeleteBookHotelResponse{
        return apiRequest {
            HotelBookAPI.deletebookHotel(
                ServiceBuilder.token!!,id
            )
        }
    }

    //get all bookHotel
    suspend fun getallBookHotel(id: String):GetAllBookHotelResponse{
        return apiRequest {
            HotelBookAPI.getallBookHotel(
                ServiceBuilder.token!!,id
            )
        }
    }
}