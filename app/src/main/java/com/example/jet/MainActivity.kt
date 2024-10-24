package com.example.jet

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jet.ui.theme.JetTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        TextFieldWithButton()
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldWithButton() {
    val context = LocalContext.current
    var text by remember { mutableStateOf("") }  // Estado para armazenar o texto digitado

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp) // Espaço entre os elementos
    ) {
        // Caixa de texto para entrada do usuário
        TextField(
            value = text,
            onValueChange = { text = it },  // Atualiza o estado com o texto digitado
            label = { Text("Digite algo") },  // Label (rótulo) que aparece dentro da caixa
            modifier = Modifier
                .fillMaxWidth(0.8f)  // Define a largura da caixa de texto como 80% da tela
        )

        // Botão que mostra o texto digitado em um Toast
        Button(
            onClick = {
                Toast.makeText(context, "Texto digitado: $text", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        ) {
            Text("Mostrar Texto")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                TextFieldWithButton()
            }
        }
    }
}
