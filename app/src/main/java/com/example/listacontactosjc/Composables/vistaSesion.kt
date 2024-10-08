package com.example.listacontactosjc.Composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun SesionView(){
    var textUs by rememberSaveable { mutableStateOf("") }
    var textPs by rememberSaveable { mutableStateOf("") }
    Column(){
        TextField(
            value = textUs,
            onValueChange = { textUs = it },
            label = { Text("Usuario") }

        )
        TextField(
            value = textPs,
            onValueChange = { textPs = it },
            label = { Text("Contraseña") }
        )
        Button(onClick={}){
            Text(text = "Inicia Sesión")
        }
    }
}