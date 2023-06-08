package com.example.danplab02

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface CursoDao {
    @Query("SELECT * from curso")
    fun getAllCourses(): LiveData<List<Curso>>

    @Query("SELECT * from Curso WHERE cursoId = :courseId")
    fun getCourse(courseId: Int): Curso?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(course: Curso)

    @Delete
    suspend fun deleteCourse(course: Curso)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudentCourseR(crossRef: EstudianteCursoR)

    @Query("SELECT * from EstudianteCursoR")
    fun getAllStudentCourseCrossRef() : LiveData<List<EstudianteCursoR>>

    @Transaction
    @Query("SELECT * FROM curso WHERE cursoId = :courseId")
    fun getCourseWithStudent(courseId : Int): LiveData<List<CursoWithEstudiante>>

}