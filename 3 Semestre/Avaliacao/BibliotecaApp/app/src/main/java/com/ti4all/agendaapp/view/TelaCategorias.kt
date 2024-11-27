package com.ti4all.agendaapp.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.ti4all.agendaapp.data.Categoria
import com.ti4all.agendaapp.model.CategoriaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaCategorias(navController: NavController, categoriaViewModel: CategoriaViewModel) {
    val categoriaList by categoriaViewModel.categoriaList.collectAsState()
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var selectedCategoria: Categoria? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        categoriaViewModel.listarTodos()
    }

    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Categorias") },
            actions = {
                // Ícone de navegação para a tela Categorias
                IconButton(onClick = {
                    navController.navigate("TelaLivros") // Navega para a tela Categorias
                }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Livros")
                }
            }
        )
    },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true }
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar categorias")
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .padding(16.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            categoriaList.forEach { categoria ->
                CategoriaList(categoria = categoria,
                    onTap = { selectedCategoria = categoria },
                    onDelete = { categoriaViewModel.deletar(categoria.id) })
            }
        }
        if (showDialog) {
            CategoriaFormDialog(
                onDismissRequest = { showDialog = false }
            ) { nome ->
                categoriaViewModel.inserir(Categoria(nome = nome))
                showDialog = false
            }
        }
        if (selectedCategoria != null){
            CategoriaUpdateFormDialog(
                selectedCategoria!!,
                onDismissRequest = { selectedCategoria = null }
            ) {
                categoriaAtualizada ->
                categoriaViewModel.atualizar(categoriaAtualizada)
                selectedCategoria = null
            }
        }
    }
}

@Composable
fun CategoriaList(categoria: Categoria,
              onTap: () -> Unit,
              onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onTap() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(  // Usamos Row para posicionar os elementos lado a lado
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Nome: ${categoria.nome}")
            }

            IconButton(onClick = { onDelete() }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Excluir"
                )
            }

        }
    }
}

@Composable
fun CategoriaFormDialog(
    onDismissRequest: () -> Unit,
    onAddClick: (String) -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var nome by rememberSaveable { mutableStateOf("") }

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        onAddClick(nome)
                        onDismissRequest()
                    }
                ) {
                    Text("Adicionar Categoria")
                }
            }
        }
    }
}

@Composable
fun CategoriaUpdateFormDialog(
    categoria: Categoria,
    onDismissRequest: () -> Unit,
    onAddClick: (Categoria) -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.background,
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var nome by remember { mutableStateOf(categoria.nome) }

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        categoria.nome = nome
                        onAddClick(categoria)
                        onDismissRequest()
                    }
                ) {
                    Text("Atualizar categoria")
                }
            }
        }
    }
}