package com.example.danplab02

import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.Junction

data class CursoWithEstudiante(
    @Embedded val curso: Curso,
    @Relation(
        parentColumn = "cursoId",
        entityColumn = "estudentId",
        associateBy = Junction(EstudianteCursoR::class)

    )
    val estudiantes: List<Estudiante>

)