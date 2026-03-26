package com.example.atividadepratica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.atividadepratica.ui.theme.AtividadePraticaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtividadePraticaTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "principal") {
        composable("principal") {
            Principal(navController = navController)
        }
        composable("secundaria") {
            Secundaria(navController = navController)
        }
    }
}
@Composable
fun Principal (navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).background(color = colorResource(R.color.purple_500)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(text = "Padaria da Lia", modifier = Modifier.padding(20.dp), color = Color.White, fontSize = 24.sp
        )
        Text("Vá para a próxima tela para nos conhecer um pouco mais!", modifier = Modifier.padding(30.dp))
        Button(onClick = { navController.navigate("secundaria") }) {
            Text("Ir para a próxima página")
        }
    }
}

@Composable
fun Secundaria (navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp).background(color = colorResource(R.color.purple_500)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sobre a Padaria", fontSize = 25.sp, modifier = Modifier.padding(20.dp), color = Color.White)
        Text(text = "A Padaria da Lia é um lugar acolhedor, conhecido pelo cheirinho de pão fresco que sai do forno todos os dias." +
                " Oferece pães, bolos e salgados feitos com carinho, sempre prezando pela qualidade e pelo bom atendimento. " +
                "É o ponto ideal para começar o dia com um café gostoso ou fazer uma pausa e aproveitar algo saboroso.", fontSize = 20.sp, color = Color.White)
        Button(onClick = { navController.popBackStack() }) {
            Text("Voltar para página principal")
        }
    }
}