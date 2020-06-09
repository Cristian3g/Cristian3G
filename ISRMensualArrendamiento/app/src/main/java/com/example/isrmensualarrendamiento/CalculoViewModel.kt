package com.example.isrmensualarrendamiento

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CalculoViewModel(private val calculoRepository: CalculoRepository): ViewModel()
{
    val Calculos = calculoRepository.obtenerDatos()

    fun guardarCalculos(Calculo: CalculosRealizados)
    {
        viewModelScope.launch {
            calculoRepository.guardarCalculo(Calculo)
        }
    }
}