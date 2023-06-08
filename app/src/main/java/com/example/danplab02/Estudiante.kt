package com.example.danplab02

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiante")
data class Estudiante(
    @PrimaryKey(autoGenerate = true)
    val estudianteId: Int,

    @ColumnInfo(name = "nombre_apellido")
    val name: String,
)