package com.example.danplab02

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel (application: Application) : AndroidViewModel(application) {

    private val allCourseData: LiveData<List<Curso>>
    private val allStudentData: LiveData<List<Estudiante>>
    private val allStudentCourseCrossRef: LiveData<List<EstudianteCursoR>>
    private val repository: Repository

    init {
        val database = AppDatabase.getInstance(application)
        val courseDao = database.courseDao
        val studentDao = database.studentDao
        repository = Repository(courseDao, studentDao)
        allCourseData = repository.allCourse
        allStudentData = repository.allStudent
        allStudentCourseCrossRef = repository.allCourseWithStudent
    }

    fun getAllStudentCourseCrossRef(): LiveData<List<EstudianteCursoR>>{
        return allStudentCourseCrossRef
    }

    fun getAllCourse(): LiveData<List<Curso>> {
        return allCourseData
    }
    fun addCourse(course: Curso){
        viewModelScope.launch {
            repository.addCourse(course)
        }
    }

    fun addStudentCourseCrossRef(crossRef: EstudianteCursoR ){
        viewModelScope.launch {
            repository.addRef(crossRef)
        }
    }

    fun getAllStudent() : LiveData<List<Estudiante>> {
        return allStudentData
    }
    fun addStudent(student: Estudiante){
        viewModelScope.launch {
            repository.addStudent(student)
        }
    }
}