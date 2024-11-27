package com.ti4all.agendaapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ti4all.agendaapp.BibliotecaApplication
import com.ti4all.agendaapp.data.Categoria
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoriaViewModel(application: BibliotecaApplication) : ViewModel()  {
    private val categoriaDao = application.database.categoriaDao()
    private val _categoriaList = MutableStateFlow<List<Categoria>>(emptyList())
    val categoriaList : StateFlow<List<Categoria>> = _categoriaList

    init {
        listarTodos()
    }

    // Construtor padrão necessário para ViewModelProvider
    @Suppress("unused")
    constructor() : this(BibliotecaApplication.instance)

    fun listarTodos() {
        viewModelScope.launch {
            _categoriaList.value = categoriaDao.listarTodos()
        }
    }

    fun inserir(categoria: Categoria) {
        viewModelScope.launch {
            categoriaDao.inserir(categoria)
            listarTodos()
        }
    }

    fun buscar(id: Long) {
        viewModelScope.launch {
            categoriaDao.buscar(id)
            listarTodos()
        }
    }

    fun deletar(id: Long) {
        viewModelScope.launch {
            categoriaDao.deletear(id)
            listarTodos()
        }
    }

    fun atualizar(categoria: Categoria){
        viewModelScope.launch {
            categoriaDao.atualizar(categoria)
            listarTodos()
        }
    }
}