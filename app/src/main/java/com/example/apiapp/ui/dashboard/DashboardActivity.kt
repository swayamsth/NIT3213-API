package com.example.apiapp.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiapp.R
import com.example.apiapp.data.model.Entity
import com.example.apiapp.ui.details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    private val viewModel: DashboardViewModel by viewModels()
    private lateinit var adapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        adapter = EntityAdapter {
            startActivity(Intent(this, DetailsActivity::class.java).putExtra("entity", it))
        }

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@DashboardActivity)
            this.adapter = adapter
        }

        val keypass = intent.getStringExtra("keypass") ?: return
        viewModel.loadEntities(keypass)
        viewModel.entities.observe(this) { adapter.submitList(it) }
    }
}
