package com.example.listacontactosjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.listacontactosjc.ui.theme.ListaContactosJCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ListaContactosJCTheme {
                NavHost(
                    navController = navController,
                    startDestination = "Inicio"
                ){
                    composable("Inicio") {
                        Inicio(navController)
                    }
                    composable("Fotos") {
                        Fotos(navController)
                    }
                    /*
                    composable("Foto1") { Foto1(navController) }
                    composable("Foto2") { Foto2(navController) }
                    composable("Foto3") { Foto3(navController) }
                    composable("Foto4") { Foto4(navController) }
                    */
                }
            }
        }
    }

    @Composable
    fun Inicio(navController: NavHostController) {
        Row(modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically){
            Text(text = "Inicio", fontSize = 30.sp)
            Imagen(image = R.drawable.ic_launcher_foreground)
        }
        BarraNavegacion(navController = navController)
    }
    @Composable
    fun Fotos(navController: NavHostController) {
        Scroll(itemPicture = listOf(
            Picture("Foto1", painterResource(R.drawable.fem)),
            Picture("Foto2", painterResource(R.drawable.male)),
            Picture("Foto3", painterResource(R.drawable.ic_launcher_background)),
            Picture("Foto4", painterResource(R.drawable.ic_launcher_foreground)),
        ))
        BarraFotos(navController = navController)
        BarraNavegacion(navController = navController)
    }
    @Composable
    fun Imagen(image:Int){
        Image(
            painterResource(id = image),
            contentDescription = "Holi",
        )
    }
    @Composable
    fun BarraNavegacion(navController: NavHostController) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(onClick = { navController.navigate("Inicio") }) {
                Text(text = "Inicio")
            }
            Button(onClick = { navController.navigate("Fotos") }) {
                Text(text = "Fotos")
            }
        }
    }
    @Composable
    fun BarraFotos(navController: NavHostController) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Button(onClick = { navController.navigate("Foto1") }) {
                Text(text = "1")
            }
            Button(onClick = { navController.navigate("Foto2") }) {
                Text(text = "2")
            }
            Button(onClick = { navController.navigate("Foto3") }) {
                Text(text = "3")
            }
            Button(onClick = { navController.navigate("Foto4") }) {
                Text(text = "4")
            }
        }
    }

    /*
    @Composable
    fun Foto1(navController:NavHostController){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.male),
            contentDescription = "Foto1",
        )
        BarraFotos(navController = navController)
    }
    @Composable
    fun Foto2(navController:NavHostController){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.fem),
            contentDescription = "Foto1",
        )
        BarraFotos(navController = navController)
    }
    @Composable
    fun Foto3(navController:NavHostController){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Foto1",
        )
        BarraFotos(navController = navController)
    }
    @Composable
    fun Foto4(navController:NavHostController){
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = "Foto1",
        )
        BarraFotos(navController = navController)
    }
    */
    @Composable
    fun Scroll(itemPicture: List<Picture>) {
        Column(verticalArrangement = Arrangement.SpaceEvenly) {
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
            ) {
                for (item in itemPicture){
                    FotoView(item)
                }
            }
        }

    }

    @Composable
    fun FotoView(pic:Picture){
        Image(
            painter = pic.painter,
            contentDescription = pic.name,
            modifier = Modifier.size(300.dp),
            alignment = Alignment.Center
        )
    }
}

