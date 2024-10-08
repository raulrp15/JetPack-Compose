package com.example.listacontactosjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.listacontactosjc.Composables.ItemList

class ListaContacto : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ItemList(
                itemContacto = listOf(
                    Contacto("Juan","611123456", 0),
                    Contacto("María","678456123", 1),
                    Contacto("Raúl","644789456",0),
                    Contacto("Ana","693882147", 1),
                    Contacto("Pablo","693882147", 0),
                    Contacto("Nuñez","693882147", 0),
                    Contacto("Maravilla","693882147", 1),
                    Contacto("Luis","693882147", 0),
                    Contacto("Ezequiel","693882147", 0),
                )
            )
        }
    }
}