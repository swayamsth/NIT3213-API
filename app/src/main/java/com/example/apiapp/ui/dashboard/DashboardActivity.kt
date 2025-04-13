package com.example.apiapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.R
import com.example.apiapp.data.model.Entity
import com.example.apiapp.ui.details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: EntityAdapter
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        recyclerView = findViewById(R.id.recyclerView)

        adapter = EntityAdapter { entity ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("entity", entity)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val keypass = intent.getStringExtra("keypass") ?: return
        Log.d("DashboardActivity", "Received keypass: $keypass")

        viewModel.loadEntities(keypass)

        viewModel.entities.observe(this) { list ->
            Log.d("DashboardActivity", "Entity list size: ${list.size}")
             adapter.submitList(list)
        }
    }
}
