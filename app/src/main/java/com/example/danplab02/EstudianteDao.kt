package com.example.danplab02

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.*

@Dao
interface EstudianteDao {

    @Query("SELECT * from estudiante")
    fun getAllStudents(): LiveData<List<Estudiante>>

    @Query("SELECT * from estudiante WHERE estudianteId = :studentId")
    fun getStudent(studentId: Int): Estudiante?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudent(student: Estudiante)

    @Delete
    suspend fun deleteStudent(student: Estudiante)

    @Transaction
    @Query("SELECT * FROM estudiante WHERE estudianteId = :StudentId")
    fun getStudentWithCourse(StudentId : Int): LiveData<List<EstudianteWithCurso>>

}