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

// Funcion JC que muestra un menu de inicio de sesion
@Composable
fun SesionView(){
    // Texto para insertar el nombre del usuario que guarda el nombre, en este caso vacio
    var textUs by rememberSaveable { mutableStateOf("") }
    // Texto para insertar la contraseña del usuario que guarda el nombre, en este caso vacio
    var textPs by rememberSaveable { mutableStateOf("") }
    // Se recoge el contexto actual
    val context:Context = LocalContext.current

    // Se crea una columna que tendrá dos insertadores de texto, uno para el nombre del usuario y
    // otro para la contraseña de este, y un boton que pasara a la pantalla de la lista de contactos
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