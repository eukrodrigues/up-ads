package com.ti4all.agendaapp.view

import android.content.Context
import android.content.Intent
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
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import com.ti4all.agendaapp.RetrofitInstance
import com.ti4all.agendaapp.data.Categoria
import com.ti4all.agendaapp.model.CategoriaViewModel
import com.ti4all.agendaapp.data.Livro
import com.ti4all.agendaapp.model.LivroViewModel
import com.ti4all.agendaapp.data.api.Book
import com.ti4all.agendaapp.data.api.BooksResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaLivros(navController: NavController, livroViewModel: LivroViewModel, categoriaViewModel: CategoriaViewModel) {
    val livrosComCategoria by livroViewModel.livroList.collectAsState()
    val categoriaList by categoriaViewModel.categoriaList.collectAsState()
    var showDialog by rememberSaveable { mutableStateOf(false) }
    var selectedLivro: Livro? by rememberSaveable { mutableStateOf(null) }

    LaunchedEffect(navController.currentBackStackEntry) {
        livroViewModel.listarTodos()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Biblioteca Virtual") },
                actions = {
                    IconButton(onClick = {
                        navController.navigate("TelaCategorias")
                    }) {
                        Icon(Icons.Filled.ArrowForward, contentDescription = "Categorias")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { showDialog = true }) {
                Icon(Icons.Filled.Add, contentDescription = "Adicionar livro")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            livrosComCategoria.forEach { item ->
                LivroList(
                    livro = item.livro,
                    categoriaNome = item.categoriaNome, // Exibe o nome da categoria associado
                    onTap = { selectedLivro = item.livro },
                    onDelete = { livroViewModel.deletar(item.livro.id) }
                )
            }
        }

        // Formulário para adicionar livro
        if (showDialog) {
            LivroFormDialog(
                categorias = categoriaList, // Passe categorias conforme necessário
                onDismissRequest = { showDialog = false }
            ) { titulo, autor, categoriaId ->
                livroViewModel.inserir(Livro(titulo = titulo, autor = autor, categoriaId = categoriaId))
                showDialog = false
            }
        }

        // Formulário para editar livro
        if (selectedLivro != null) {
            LivroUpdateFormDialog(
                selectedLivro!!,
                onDismissRequest = { selectedLivro = null }
            ) { livroAtualizado ->
                livroViewModel.atualizar(livroAtualizado)
                selectedLivro = null
            }
        }
    }
}

@Composable
fun LivroList(
    livro: Livro,
    categoriaNome: String,  // Agora recebendo o nome da categoria diretamente
    onTap: () -> Unit,
    onDelete: () -> Unit
) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onTap() },
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f)
            ) {
                Text(text = "Titulo: ${livro.titulo}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Autor: ${livro.autor}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Categoria: $categoriaNome")  // Exibindo o nome da categoria
            }

            IconButton(onClick = { compartilharLivro(context, livro.titulo, livro.autor) }) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = "Compartilhar"
                )
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LivroFormDialog(
    categorias: List<Categoria>,
    onDismissRequest: () -> Unit,
    onAddClick: (String, String, Long) -> Unit
) {
    var titulo by rememberSaveable { mutableStateOf("") }
    var autor by rememberSaveable { mutableStateOf("") }
    var categoriaSelecionada by rememberSaveable { mutableStateOf<Categoria?>(null) }
    var expanded by rememberSaveable { mutableStateOf(false) }
    var suggestedBooks by rememberSaveable { mutableStateOf<List<Book>>(emptyList()) }
    var showSuggestionsDialog by rememberSaveable { mutableStateOf(false) }

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
                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Título") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = autor,
                    onValueChange = { autor = it },
                    label = { Text("Autor") }
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Dropdown para seleção de categoria
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = categoriaSelecionada?.nome ?: "Selecione uma categoria",
                        onValueChange = {},
                        label = { Text("Categoria") },
                        readOnly = true,
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        categorias.forEach { categoria ->
                            DropdownMenuItem(
                                text = { Text(categoria.nome) },
                                onClick = {
                                    categoriaSelecionada = categoria
                                    expanded = false
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        searchBooks(titulo) { books ->
                            suggestedBooks = books
                            showSuggestionsDialog = true // Abre o Dialog com sugestões
                        }
                    }
                ) {
                    Text("Buscar Livro")
                }

                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (categoriaSelecionada != null) {
                            onAddClick(titulo, autor, categoriaSelecionada!!.id)
                            onDismissRequest()
                        }
                    }
                ) {
                    Text("Adicionar Livro")
                }
            }
        }
    }

    // Dialog para exibir sugestões de livros
    if (showSuggestionsDialog) {
        Dialog(onDismissRequest = { showSuggestionsDialog = false }) {
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
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Sugestões de Livros", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))

                    suggestedBooks.forEach { book ->
                        Text(
                            text = book.volumeInfo.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    titulo = book.volumeInfo.title
                                    autor = book.volumeInfo.authors?.joinToString(", ") ?: ""
                                    showSuggestionsDialog = false // Fecha o Dialog ao selecionar
                                }
                                .padding(8.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = { showSuggestionsDialog = false }) {
                        Text("Fechar")
                    }
                }
            }
        }
    }
}

@Composable
fun LivroUpdateFormDialog(
    livro: Livro,
    onDismissRequest: () -> Unit,
    onAddClick: (Livro) -> Unit
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
                var titulo by remember { mutableStateOf(livro.titulo) }
                var autor by remember { mutableStateOf(livro.autor) }
                var categoriaId by remember { mutableStateOf(livro.categoriaId) }

                OutlinedTextField(
                    value = titulo,
                    onValueChange = { titulo = it },
                    label = { Text("Titulo") }
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = autor,
                    onValueChange = { autor = it },
                    label = { Text("Autor") }
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        livro.titulo = titulo
                        livro.autor = autor
                        onAddClick(livro)
                        onDismissRequest()
                    }
                ) {
                    Text("Atualizar livro")
                }
            }
        }
    }
}

fun searchBooks(title: String, onResult: (List<Book>) -> Unit) {
    val call = RetrofitInstance.api.searchBooksByTitle(title)

    call.enqueue(object : Callback<BooksResponse> {
        override fun onResponse(call: Call<BooksResponse>, response: Response<BooksResponse>) {
            if (response.isSuccessful) {
                val books = response.body()?.items.orEmpty()
                onResult(books)
            } else {
                println("Error: ${response.errorBody()?.string()}")
                onResult(emptyList())
            }
        }

        override fun onFailure(call: Call<BooksResponse>, t: Throwable) {
            println("Failure: ${t.message}")
            onResult(emptyList())
        }
    })
}

fun compartilharLivro(context: Context, titulo: String, autor: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, "Detalhes do Livro")
        putExtra(
            Intent.EXTRA_TEXT,
            "Confira este livro: \nTítulo: $titulo\nAutor: $autor"
        )
    }
    context.startActivity(Intent.createChooser(intent, "Compartilhar via"))
}