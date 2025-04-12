package com.example.apiapp.repository

import com.example.apiapp.data.api.ApiService
import com.example.apiapp.data.model.LoginRequest
import javax.inject.Inject

class MainRepository @Inject constructor(private val api: ApiService) {
    suspend fun login(location: String, request: LoginRequest) = api.login(location, request)
    suspend fun getDashboard(keypass: String) = api.getDashboard(keypass)
}