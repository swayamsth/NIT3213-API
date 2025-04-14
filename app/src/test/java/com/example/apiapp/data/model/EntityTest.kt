package com.example.apiapp.data.model

import org.junit.Assert.*
import org.junit.Test

class EntityTest {

    @Test
    fun `Entity fields hold correct values`() {
        val entity = Entity(
            dishName = "Sushi",
            origin = "Japan",
            mainIngredient = "Rice",
            mealType = "Lunch/Dinner",
            description = "A Japanese dish of prepared vinegared rice accompanied by various ingredients."
        )

        assertEquals("Sushi", entity.dishName)
        assertEquals("Japan", entity.origin)
        assertEquals("Rice", entity.mainIngredient)
        assertEquals("Lunch/Dinner", entity.mealType)
        assertTrue(entity.description.contains("vinegared rice"))
    }
}
