package com.ti4all.agendaapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ti4all.agendaapp.data.Categoria

@Dao
interface CategoriaDao {

    @Insert
    suspend fun inserir(categoria: Categoria)

    @Query("SELECT * FROM categoria")
    suspend fun listarTodos() : List<Categoria>

    @Query("SELECT * FROM categoria WHERE id = :id")
    suspend fun buscar(id: Long) : Categoria

    @Query("DELETE FROM categoria WHERE id = :id")
    suspend fun deletear(id: Long)

    @Update
    suspend fun atualizar(categoria: Categoria)
}