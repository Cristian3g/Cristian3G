package com.example.isrmensualarrendamiento

class CalculoRepository(val calculoDao: CalculosDao) {
    suspend fun guardarCalculo(calculo: CalculosRealizados) = calculoDao.guardarCalculos(calculo)
    fun obtenerDatos() = calculoDao.obtenerCalculos()
}