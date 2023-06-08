package com.example.danplab02

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "curso")
data class Curso(
    @PrimaryKey(autoGenerate = true)
    val cursoId: Int,

    @ColumnInfo(name = "nombre")
    val name: String,

    )