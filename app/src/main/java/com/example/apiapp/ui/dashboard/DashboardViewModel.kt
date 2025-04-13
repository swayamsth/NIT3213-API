package com.example.apiapp.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapp.data.model.Entity
import com.example.apiapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _entities = MutableLiveData<List<Entity>>()
    val entities: LiveData<List<Entity>> = _entities

    fun loadEntities(keypass: String) {
        viewModelScope.launch {
            try {
                val res = repository.getDashboard(keypass)
                if (res.isSuccessful && res.body() != null) {
                    val data = res.body()
                    Log.d("Dashboard", "Entity count: ${data?.entityTotal}, list: ${data?.entities}")
                    data?.entities?.forEachIndexed { i, entity ->
                        Log.d("Dashboard", "[$i] ${entity.dishName} - ${entity.origin}")
                    }
                    _entities.value = data?.entities ?: emptyList()
                } else {
                    Log.e("Dashboard", "Response error: ${res.code()} - ${res.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.e("Dashboard", "Exception: ${e.message}")
            }
        }
    }
}
