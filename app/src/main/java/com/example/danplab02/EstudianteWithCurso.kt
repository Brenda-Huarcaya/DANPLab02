package com.example.danplab02

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class EstudianteWithCurso(
    @Embedded val student: Estudiante,
    @Relation(
        parentColumn = "studentId",
        entityColumn = "courseId",
        associateBy = Junction(EstudianteCursoR::class)
    )
    val course: List<Curso>
)