package com.example.apiapp.ui.details

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.apiapp.R
import com.example.apiapp.data.model.Entity
import com.example.apiapp.ui.dashboard.DashboardActivity
import com.google.android.material.button.MaterialButton

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val entity = intent.getSerializableExtra("entity") as? Entity ?: return

        findViewById<TextView>(R.id.dishName).text = entity.dishName
        findViewById<TextView>(R.id.origin).text = "Origin: ${entity.origin}"
        findViewById<TextView>(R.id.mainIngredient).text = "Main ingredient: ${entity.mainIngredient}"
        findViewById<TextView>(R.id.mealType).text = entity.mealType
        findViewById<TextView>(R.id.description).text = entity.description

        val dashboardBtn = findViewById<MaterialButton>(R.id.backToDashboardBtn)

        dashboardBtn.setOnClickListener {

            finish()
        }

    }
}
