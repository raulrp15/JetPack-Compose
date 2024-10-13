package com.example.listacontactosjc.Composables

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactosjc.Contacto
import com.example.listacontactosjc.R

// Funcion que retorna la inicial del nombre del contacto
fun iniciales(nombre:String):Char{
    var letras = nombre.toCharArray()
    var inicial = letras[0]
    return inicial
}

// Funcion JC que crea el layaout de la lista de contactos en dos columnas
@Composable
fun ItemList(itemContacto: List<Contacto>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(itemContacto) { itemContacto ->
            ContactoView(contacto = itemContacto)
    }
    }
}
/*
    Funcion JC que crea una tarjeta con los contactos, al principio solo se verá la foto con
    la inicial, si hace click sobre el contacto se muestra el nombre completo junto al telefono,
    que al hacer click sobre este llamará al contacto
*/
@Composable
fun ContactoView(contacto: Contacto) {
    // Coge el contexto que se está ejecutando
    val context = LocalContext.current
    // Booleano que recuerda el estado en el que se encuentra la vista del contacto
    var entero by remember { mutableStateOf(false) }
    // Se crea un objeto tipo foto para el icono del contacto
    var foto = R.drawable.male
    // En el caso de que el entero asociado al sexo sea 1, se pondrá el icono de una mujer
    if(contacto.sexo == 1)
        foto = R.drawable.fem
    // Esta funcion inicia la llamada al numero de telefono asociado
    fun iniciarMarcacion() {
        // Se crea un intento de abrir el dial de telefono para llamar al contacto
        val intent = Intent(Intent.ACTION_DIAL).apply {
            // El dato asociado al dial es el numero del contacto
            data = Uri.parse("tel:${contacto.tfno}")
        }
        // Si los permisos son correctos se pasa al la pantalla del dial
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        }
    }
    // Se crea una tarjeta con los datos dell contacto, al hacer click se hace una animacion
    Card(Modifier.fillMaxWidth()
        .clickable { entero = !entero }) {
            Column {
                AnimatedVisibility(visible = !entero, enter = fadeIn(), exit = fadeOut()) {
                    Row {
                        Image(
                        painter = painterResource(id = foto),
                        contentDescription = "Foto contacto",
                        Modifier.height(100.dp)
                        )
                        Text(
                            text = iniciales(contacto.name).toString(),
                            fontSize = 60.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }

                }
                AnimatedVisibility(visible = entero, enter = fadeIn(), exit = fadeOut()) {
                    Column (Modifier.padding(8.dp)) {
                    Text(
                        text = contacto.name,
                        fontSize = 38.sp,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = contacto.tfno,
                        fontSize = 24.sp,
                        modifier = Modifier.padding(8.dp)
                            .clickable { iniciarMarcacion() }
                    )
                    }
                }
            }
    }
}