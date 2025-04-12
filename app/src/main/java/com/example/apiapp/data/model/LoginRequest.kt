package com.example.apiapp.data.model


data class LoginRequest(val username: String, val password: String)

data class LoginResponse(val keypass: String)

data class DashboardResponse(
    val entities: List<Entity>,
    val entityTotal: Int
)