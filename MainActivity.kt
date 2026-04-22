// MainActivity.kt
package com.example.atividade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.atividade.LojaScreen
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LojaScreen()
        }
    }
}


data class Produto(
    val nome: String,
    val imagemUrl: String
)

@Composable
fun LojaScreen() {

    var listaProdutos by remember {
        mutableStateOf(
            listOf(
                Produto(
                    "Arara",
                    "http://www.wikiaves.com.br/wiki/arara-vermelha"
                ),
                Produto(
                    "Lobo-Guará",
                    "https://pt.quizur.com/trivia/lobo-guara-projeto-animais-em-extincao-1qtHM"
                ),
                Produto(
                    "Tamanduá",
                    "https://www.correiobraziliense.com.br/aqui/2025/09/04/a-vida-secreta-do-tamandua-bandeira-o-simbolo-do-cerrado/"
                )
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_loja),
            contentDescription = "Logo da loja",
            modifier = Modifier
                .size(120.dp)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                listaProdutos = listaProdutos + Produto(
                    "Novo Produto ${listaProdutos.size + 1}",
                    "https://images.unsplash.com/photo-1505740420928-5e560c06d30e"
                )
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Adicionar Produto")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(listaProdutos) { produto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {

                        AsyncImage(
                            model = produto.imagemUrl,
                            contentDescription = produto.nome,
                            placeholder = painterResource(R.drawable.loading),
                            error = painterResource(R.drawable.erro),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            contentScale = ContentScale.Crop
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = produto.nome,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
