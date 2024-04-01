package com.example.di_recyclerview.data.repository

import com.example.di_recyclerview.data.api.ApiHelper

class MainRepository(private val apiHelper: ApiHelper) {
    suspend fun getUsers() =  apiHelper.getUsers()
}