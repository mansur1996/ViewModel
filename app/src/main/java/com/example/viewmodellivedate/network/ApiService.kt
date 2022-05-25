package com.example.viewmodellivedate.network

import com.example.viewmodellivedate.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<List<User>>
}