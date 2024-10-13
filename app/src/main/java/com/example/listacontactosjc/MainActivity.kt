package com.example.listacontactosjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import com.example.listacontactosjc.Composables.ItemList
import com.example.listacontactosjc.Composables.SesionView

class MainActivity : ComponentActivity() {
    // Funcion que crea la pantalla y muestra el layout del inicio de sesion
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SesionView()
        }
    }
}

