package com.prueba.pruebatecnica.data.repository

import com.prueba.pruebatecnica.data.model.User
import com.prueba.pruebatecnica.data.network.ApiService

class UserRepository(private val apiService: ApiService) {
    suspend fun getUsers(page: Int): List<User> {
        return apiService.getUsers(page).data
    }
}