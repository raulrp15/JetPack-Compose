package com.example.listacontactosjc.Composables

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactosjc.Contacto
import com.example.listacontactosjc.R

fun iniciales(nombre:String):Char{
    var letras = nombre.toCharArray()
    var inicial = letras[0]
    return inicial
}

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
@Composable
fun ContactoView(contacto: Contacto) {
    var entero by remember { mutableStateOf(false) }
    var foto = R.drawable.male
    if(contacto.sexo == 1)
        foto = R.drawable.fem
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
                    )
                    }
                }
            }
    }
}