package com.example.apiapp.data.model

import java.io.Serializable

data class Entity(
    val dishName: String,
    val origin: String,
    val mainIngredient: String,
    val mealType: String,
    val description: String
) : Serializable
