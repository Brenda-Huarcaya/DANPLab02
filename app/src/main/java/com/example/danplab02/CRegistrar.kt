package com.example.danplab02

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CRegister(viewModel: MainViewModel){
    var cursoN by rememberSaveable { mutableStateOf(("")) }

    LazyColumn(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(), verticalArrangement = Arrangement.Center ) {

        item {
            Text(text = "Registrar Curso ", textAlign = TextAlign.Center,
                modifier = Modifier.width(150.dp),fontSize = 30.sp,fontWeight = FontWeight.ExtraBold)

            TextField(
                value = cursoN,
                onValueChange = {
                    cursoN = it

                } ,
                label = { Text(text = "Nombre del Curso") }
            )
            Button(onClick = { viewModel.addCourse(Curso(0, cursoN)) }) {
                Text(text = "Registrar")
            }
        }
    }

}