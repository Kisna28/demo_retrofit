package com.example.demo_retrofit.network

import com.example.demo_retrofit.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<UserResponse>
}
