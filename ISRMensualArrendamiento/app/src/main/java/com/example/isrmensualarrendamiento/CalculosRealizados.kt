package com.example.isrmensualarrendamiento

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Calculos")
data class CalculosRealizados (
    @PrimaryKey var uid: String,
    @ColumnInfo(name = "Nombre") val Nombre: String?,
    @ColumnInfo(name = "SubTotal") val SubTotal: Double?,
    @ColumnInfo(name = "Total") val Total: Double?
)