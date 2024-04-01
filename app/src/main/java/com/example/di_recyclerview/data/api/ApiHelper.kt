package com.example.di_recyclerview.data.api

import com.example.di_recyclerview.data.model.User
import retrofit2.Response

interface ApiHelper {
    suspend fun getUsers(): Response<List<User>>
}