package com.example.listacontactosjc.Composables

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.example.listacontactosjc.ListaContacto
import com.example.listacontactosjc.MainActivity

@Composable
fun SesionView(){
    var textUs by rememberSaveable { mutableStateOf("") }
    var textPs by rememberSaveable { mutableStateOf("") }
    val context:Context = LocalContext.current

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
        Button(onClick={
            val cambia = Intent(context, ListaContacto::class.java)
            context.startActivity(cambia)
        }){
            Text(text = "Inicia Sesión")
        }
    }
}