package com.example.apiapp.ui.dashboard

import android.view.*
import android.widget.TextView
import androidx.recyclerview.widget.*
import com.example.apiapp.R
import com.example.apiapp.data.model.Entity

class EntityAdapter(
    private val onClick: (Entity) -> Unit
) : ListAdapter<Entity, EntityAdapter.ViewHolder>(DIFF) {

    companion object {
        val DIFF = object : DiffUtil.ItemCallback<Entity>() {
            override fun areItemsTheSame(oldItem: Entity, newItem: Entity) =
                oldItem.property1 == newItem.property1

            override fun areContentsTheSame(oldItem: Entity, newItem: Entity) =
                oldItem == newItem
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(entity: Entity) {
            itemView.findViewById<TextView>(R.id.prop1).text = entity.property1
            itemView.findViewById<TextView>(R.id.prop2).text = entity.property2
            itemView.setOnClickListener { onClick(entity) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
