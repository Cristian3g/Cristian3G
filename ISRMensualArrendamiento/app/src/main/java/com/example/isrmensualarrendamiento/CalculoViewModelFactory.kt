package com.example.isrmensualarrendamiento

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CalculoViewModelFactory(private val calculoRepository: CalculoRepository): ViewModelProvider.NewInstanceFactory()
{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T
    {
        return CalculoViewModel(
            calculoRepository
        ) as T
    }
}