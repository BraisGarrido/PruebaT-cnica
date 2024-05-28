package com.prueba.pruebatecnica.data.network

import com.prueba.pruebatecnica.data.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): UserResponse
}