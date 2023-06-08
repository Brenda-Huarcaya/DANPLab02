package com.example.danplab02

import androidx.lifecycle.LiveData

class Repository(private val cursoDao: CursoDao, private val estudianteDao: EstudianteDao) {

    val allCourse  : LiveData<List<Curso>> = cursoDao.getAllCourses()
    val allStudent  : LiveData<List<Estudiante>> = estudianteDao.getAllStudents()
    val allCourseWithStudent  : LiveData<List<EstudianteCursoR>> = cursoDao.getAllStudentCourseCrossRef()

    suspend fun addRef(crossRef: EstudianteCursoR){
        cursoDao.insertStudentCourseR(crossRef)
    }

    suspend fun addStudent(student: Estudiante ){
        estudianteDao.insertStudent(student)
    }

    suspend fun deleteStudent(student: Estudiante ){
        estudianteDao.deleteStudent(student)
    }

    suspend fun addCourse(course: Curso){
        cursoDao.insertCourse(course)
    }

    suspend fun deleteCourse(course: Curso){
        cursoDao.deleteCourse(course)
    }

}
