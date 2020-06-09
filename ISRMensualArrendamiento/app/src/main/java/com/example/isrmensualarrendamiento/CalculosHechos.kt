package com.example.isrmensualarrendamiento

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CalculosHechos : AppCompatActivity() {
    lateinit var calculos: ArrayList<Calculos>

    private val calculoViewModel: CalculoViewModel by viewModels{
        CalculoViewModelFactory(
            CalculoRepository(CalculosDataBase.getDataBase(this).calculosDao())
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculos_hechos)

        // Lookup the recyclerview in activity layout
        val rvCalculos = findViewById<View>(R.id.rvCalculos) as RecyclerView
        // Initialize contacts

        calculos = Calculos.createCalculosList()

        // Create adapter passing in the sample user data
        val adapter = CalculosAdapter(calculos)
        // Attach the adapter to the recyclerview to populate items
        rvCalculos.adapter = adapter
        // Set layout manager to position the items
        rvCalculos.layoutManager = LinearLayoutManager(this)
        // That's all!

    }
}