package com.example.apiapp.ui.dashboard

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
            val res = repository.getDashboard(keypass)
            if (res.isSuccessful) {
                _entities.value = res.body()?.entities ?: emptyList()
            }
        }
    }
}
