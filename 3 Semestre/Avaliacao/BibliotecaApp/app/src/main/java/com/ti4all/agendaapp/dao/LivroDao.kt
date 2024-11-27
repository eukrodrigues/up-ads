package com.ti4all.agendaapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ti4all.agendaapp.data.Livro

@Dao
interface LivroDao {

    @Insert
    suspend fun inserir(livro: Livro)

    @Query("SELECT * FROM livro")
    suspend fun listarTodos() : List<Livro>

    @Query("DELETE FROM livro WHERE id = :id")
    suspend fun deletear(id: Long)

    @Update
    suspend fun atualizar(livro: Livro)
}