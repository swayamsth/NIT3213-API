package com.example.apiapp.repository

import com.example.apiapp.data.api.ApiService
import com.example.apiapp.data.model.*
import kotlinx.coroutines.test.runTest
import okhttp3.ResponseBody
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.*
import retrofit2.Response

class MainRepositoryTest {

    private lateinit var api: ApiService
    private lateinit var repository: MainRepository

    @Before
    fun setup() {
        api = mock()
        repository = MainRepository(api)
    }

    @Test
    fun `login returns successful keypass`() = runTest {
        val request = LoginRequest("Swayam", "s8105134")
        val response = Response.success(LoginResponse("food"))
        whenever(api.login("sydney", request)).thenReturn(response)

        val result = repository.login("sydney", request)
        assertTrue(result.isSuccessful)
        assertEquals("food", result.body()?.keypass)
    }

    @Test
    fun `getDashboard returns list of 7 entities`() = runTest {
        val list = (1..7).map { i ->
            Entity("Dish $i", "Origin", "Ingredient", "Dinner", "Description")
        }
        val response = Response.success(DashboardResponse(list, 7))
        whenever(api.getDashboard("food")).thenReturn(response)

        val result = repository.getDashboard("food")
        assertTrue(result.isSuccessful)
        assertEquals(7, result.body()?.entities?.size)
    }
}
