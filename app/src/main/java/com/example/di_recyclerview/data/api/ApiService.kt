package com.example.di_recyclerview.data.api

import com.example.di_recyclerview.data.model.User
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}