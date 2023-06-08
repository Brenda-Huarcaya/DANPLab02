package com.example.danplab02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController

@Composable
fun Lista(navController: NavHostController, viewModel: MainViewModel){

    var estudiantes = viewModel.getAllStudent().observeAsState().value
    var cursos = viewModel.getAllCourse().observeAsState().value
    var listaref = viewModel.getAllStudentCourseCrossRef().observeAsState().value

    LazyColumn() {
        if (estudiantes != null && cursos != null && listaref != null) {
            cursos.forEach {
                var aux = it
                item {
                    Row() {
                        Text(text = it.name + " : ")
                        estudiantes.forEach {
                            var aux2 = it
                            listaref.forEach {
                                if (it.courseId == aux.cursoId && it.studentId == aux2.estudianteId) {
                                    Text(text = "-->"+aux2.name)
                                }
                            }
                        }
                    }
                }

            }
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {

        Button(onClick = {
            navController.navigate("registrarCurso")
        }) {
            Text(text = "Registrar Curso")
        }

        Button(onClick = {
            navController.navigate("registrarEstudiante")
        }) {
            Text(text = "Registrar Estudiante")
        }

    }
}