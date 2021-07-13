package com.example.finalassignment.Repository

import com.example.finalassignment.API.MyApiRequest
import com.example.finalassignment.API.ServiceBuilder
import com.example.finalassignment.API.UserAPI
import com.example.finalassignment.ENTITY.User
import com.example.finalassignment.Response.LoginResponse

class UserRepository:  MyApiRequest() {
    private val userAPI = ServiceBuilder.buildService(UserAPI::class.java)

    //Register User
    suspend fun registerUser(user: User) : LoginResponse {
        return apiRequest {
            userAPI.registerUser(user)
        }
    }

    //login User
    suspend fun loginUser(username:String, password:String):LoginResponse{
        return apiRequest {
            userAPI.checkUser(username, password)
        }
    }
    //dao goes here
}




