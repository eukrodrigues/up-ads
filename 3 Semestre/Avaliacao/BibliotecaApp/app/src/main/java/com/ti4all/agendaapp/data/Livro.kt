package com.ti4all.agendaapp.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "livro", foreignKeys = [
    ForeignKey(
        entity = Categoria::class,
        parentColumns = ["id"],
        childColumns = ["categoriaId"],
        onDelete = ForeignKey.CASCADE
    )
])

data class Livro(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var titulo: String,
    var autor: String,
    val categoriaId: Long
)
