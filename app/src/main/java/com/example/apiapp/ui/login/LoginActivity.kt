package com.example.apiapp.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.apiapp.R
import com.example.apiapp.ui.dashboard.DashboardActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<Button>(R.id.loginBtn).setOnClickListener {
            val user = findViewById<EditText>(R.id.username).text.toString()
            val pass = findViewById<EditText>(R.id.password).text.toString()

            Log.d("LoginInput", "username=$user, password=$pass")

            viewModel.login(user, pass, "sydney")
        }

        viewModel.loginResult.observe(this) { result ->
            result.onSuccess {
                startActivity(Intent(this, DashboardActivity::class.java).putExtra("keypass", it))
            }.onFailure {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
