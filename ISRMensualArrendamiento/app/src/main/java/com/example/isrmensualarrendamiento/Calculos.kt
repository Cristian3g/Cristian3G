package com.example.isrmensualarrendamiento

import androidx.fragment.app.viewModels

class Calculos(val estado: String, val telefono: String) {

    companion object {
        /*private var lastId = 0*/

        fun createCalculosList(): ArrayList<Calculos> {
            val Lista = ArrayList<Calculos>()

            Lista.add(Calculos("Piedras negras","800 463 6728"))
            Lista.add(Calculos("Nuevo Laredo","556 272 2728"))
            Lista.add(Calculos("Saltillo","844 438 9280"))

            return Lista
        }
    }
}