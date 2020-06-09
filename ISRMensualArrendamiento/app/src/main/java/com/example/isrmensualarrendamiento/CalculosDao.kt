package com.example.isrmensualarrendamiento

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CalculosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun guardarCalculos(Informacion: CalculosRealizados)

    @Query("SELECT * FROM Calculos")
    fun obtenerCalculos(): LiveData<CalculosRealizados>
}