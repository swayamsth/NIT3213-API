package com.example.apiapp.data.api

import com.example.apiapp.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("{location}/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): Response<DashboardResponse>
}