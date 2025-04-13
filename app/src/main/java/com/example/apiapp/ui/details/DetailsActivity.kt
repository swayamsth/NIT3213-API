package com.example.apiapp.ui.details

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.R
import com.example.apiapp.data.model.Entity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val entity = intent.getSerializableExtra("entity") as Entity
        findViewById<TextView>(R.id.property1).text = entity.dishName
        findViewById<TextView>(R.id.property2).text = entity.origin
        findViewById<TextView>(R.id.description).text = entity.description
    }
}
