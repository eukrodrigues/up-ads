package com.example.aula08_exemplo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aula08_exemplo.ui.theme.Aula08_exemploTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            paginaInicial()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun paginaInicial(){
    var qtdeMax by remember { mutableStateOf(Random.nextInt(1, 50)) }

    iniciaAtividade(qtdeMax, onQtdeMaxChange = { novoValor ->
        qtdeMax = novoValor
    })
}

@Composable
fun iniciaAtividade(qtdeMax: Int, onQtdeMaxChange: (Int) -> Unit){
    var count by remember { mutableStateOf(0) }
    val pctRealizado by remember { derivedStateOf { count.toFloat() / qtdeMax } }

    LaunchedEffect(qtdeMax) {
        count = 0
    }

    Column {
        Text("")
        Text("")
        Text("Count: $count")
        Text("pctRealizado: $pctRealizado")
        Text("Qtde Max: $qtdeMax")
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        if(count == 0){
            Button( onClick = { count++},
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue, contentColor = Color.White),
                shape = RoundedCornerShape(8.dp)
            ){
                Text("Iniciar")
            }
        } else if(pctRealizado < 1 && pctRealizado >= 0) {
            var nomeImagem: Int
            var texto: String

            if(pctRealizado < 0.33){
                nomeImagem = R.drawable.nivel1
                texto = "Você consegue!"
            } else if(pctRealizado < 0.66){
                nomeImagem = R.drawable.nivel2
                texto = "Você está evoluindo!"
            } else{
                nomeImagem = R.drawable.nivel3
                texto = "Quase lá!"
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(texto, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Normal))
                Button(
                    onClick = { count++ },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Construir")
                }

                Button(
                    onClick = { count = -1 },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("Desistir")
                }

                Spacer(modifier = Modifier.height(24.dp))

                Image(
                painter = painterResource(id = nomeImagem),
                contentDescription = "casa sendo construída",
                modifier = Modifier.fillMaxSize()
                )
            }

        } else if(count >= 1){
            Text("Parabéns! Você conseguiu", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { onQtdeMaxChange(Random.nextInt(1, 50))},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red,
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text("Reiniciar")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.nivel4),
                contentDescription = "casa construída",
                modifier = Modifier.fillMaxSize()
            )
        } else {
            Text("Ah, que pena!", style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))

            Spacer(modifier = Modifier.height(24.dp))

            Image(
                painter = painterResource(id = R.drawable.desistencia),
                contentDescription = "desistencia",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Aula08_exemploTheme {
        Greeting("Android")
    }
}