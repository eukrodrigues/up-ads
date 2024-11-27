package com.ti4all.agendaapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ti4all.agendaapp.BibliotecaApplication
import com.ti4all.agendaapp.data.Livro
import com.ti4all.agendaapp.data.LivroComCategoria
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LivroViewModel(application: BibliotecaApplication) : ViewModel()  {
    private val livroDao = application.database.livroDao()
    private val categoriaDao = application.database.categoriaDao()
    private val _livroList = MutableStateFlow<List<LivroComCategoria>>(emptyList())
    val livroList : StateFlow<List<LivroComCategoria>> = _livroList

    init {
        listarTodos()
    }

    // Construtor padrão necessário para ViewModelProvider
    @Suppress("unused")
    constructor() : this(BibliotecaApplication.instance)

    fun listarTodos() {
        viewModelScope.launch {
            val livros = livroDao.listarTodos() // Busca todos os livros
            val livrosComCategoriaList = livros.map { livro ->
                val categoria = categoriaDao.buscar(livro.categoriaId) // Busca a categoria pelo ID
                LivroComCategoria(livro, categoria?.nome ?: "Desconhecido") // Se não encontrar a categoria, define como "Desconhecido"
            }
            _livroList.value = livrosComCategoriaList // Atualiza a lista de livros com categoria
        }
    }

    fun inserir(livro: Livro) {
        viewModelScope.launch {
            livroDao.inserir(livro)
            listarTodos()
        }
    }

    fun deletar(id: Long) {
        viewModelScope.launch {
            livroDao.deletear(id)
            listarTodos()
        }
    }

    fun atualizar(livro: Livro){
        viewModelScope.launch {
            livroDao.atualizar(livro)
            listarTodos()
        }
    }
}