package com.example.isrmensualarrendamiento

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CalculosAdapter (private val mCalculos: List<Calculos>) : RecyclerView.Adapter<CalculosAdapter.ViewHolder>() {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    inner class ViewHolder(listItemView: View) : RecyclerView.ViewHolder(listItemView) {
        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val nameTextView = itemView.findViewById<TextView>(R.id.name)
        val ultimoCalculo = itemView.findViewById<TextView>(R.id.UltimoCalculo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalculosAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.items, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(viewHolder: CalculosAdapter.ViewHolder, position: Int) {
        // Get the data model based on position
        val Calculo: Calculos = mCalculos.get(position)
        // Set item views based on your views and data model
        val textView = viewHolder.nameTextView
        textView.setText(Calculo.estado)
        val textView2 = viewHolder.ultimoCalculo
        textView2.setText(Calculo.telefono)
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return mCalculos.size
    }
}