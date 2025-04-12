package com.example.apiapp.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiapp.data.model.LoginRequest
import com.example.apiapp.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: MainRepository
) : ViewModel() {

    private val _loginResult = MutableLiveData<Result<String>>()
    val loginResult: LiveData<Result<String>> = _loginResult

    fun login(username: String, password: String, location: String) {
        viewModelScope.launch {
            try {
                val res = repository.login(location, LoginRequest(username, password))
                if (res.isSuccessful && res.body() != null) {
                    _loginResult.value = Result.success(res.body()!!.keypass)
                } else {
                    Log.e("Login", "Error code: ${res.code()}, message: ${res.errorBody()?.string()}")
                    _loginResult.value = Result.failure(Exception("Login failed"))
                }
            } catch (e: Exception) {
                Log.e("Login", "Exception: ${e.message}")
                _loginResult.value = Result.failure(e)
            }
        }
    }
}
