package com.ti4all.agendaapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ti4all.agendaapp.dao.CategoriaDao
import com.ti4all.agendaapp.dao.LivroDao
import com.ti4all.agendaapp.data.Categoria
import com.ti4all.agendaapp.data.Livro

@Database(entities = [Livro::class, Categoria::class], version = 1)
abstract class BibliotecaDatabase : RoomDatabase() {
    abstract fun livroDao() : LivroDao
    abstract fun categoriaDao() : CategoriaDao
}