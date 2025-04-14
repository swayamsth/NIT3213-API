package com.example.apiapp.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.*
import com.example.apiapp.R
import com.example.apiapp.data.model.Entity

class EntityAdapter(
    private val onClick: (Entity) -> Unit
) : ListAdapter<Entity, EntityAdapter.EntityViewHolder>(DIFF) {

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Entity>() {
            override fun areItemsTheSame(old: Entity, new: Entity) = old.dishName == new.dishName
            override fun areContentsTheSame(old: Entity, new: Entity) = old == new
        }
    }

    inner class EntityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val prop1: TextView = view.findViewById(R.id.prop1)
        private val prop2: TextView = view.findViewById(R.id.prop2)
        private val mealType: TextView = view.findViewById(R.id.mealType)

        fun bind(entity: Entity) {
            prop1.text = entity.dishName
            prop2.text = entity.origin
            mealType.text = entity.mealType
            itemView.setOnClickListener { onClick(entity) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
