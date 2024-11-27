package com.ti4all.agendaapp

import android.app.Application
import androidx.room.Room
import com.ti4all.agendaapp.data.Categoria
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BibliotecaApplication : Application() {
    lateinit var database : BibliotecaDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, BibliotecaDatabase::class.java
            , "biblioteca-db")
            .build()

        inserirCategoriasPadrao()
    }

    private fun inserirCategoriasPadrao() {
        CoroutineScope(Dispatchers.IO).launch {
            val categoriaDao = database.categoriaDao()

            if (categoriaDao.listarTodos().isEmpty()) {
                categoriaDao.inserir(Categoria(nome = "Ficção"))
                categoriaDao.inserir(Categoria(nome = "História"))
                categoriaDao.inserir(Categoria(nome = "Tecnologia"))
            }
        }
    }

    companion object {
        lateinit var instance: BibliotecaApplication
            private set
    }
}