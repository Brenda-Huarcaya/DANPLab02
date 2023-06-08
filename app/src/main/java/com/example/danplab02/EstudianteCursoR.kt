package com.example.danplab02

import androidx.room.Entity

@Entity(primaryKeys = ["studentId", "courseId"])
data class EstudianteCursoR (
    val studentId : Int,
    val courseId : Int
)
