package com.example.crud.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.crud.models.Usuarios
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuariosDataBaseDao {

    @Query("SELECT * FROM usuarios")
    fun obterUsuarios(): Flow<List<Usuarios>>

    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun  obterUsuario(id: Int): Flow<Usuarios>

    @Insert
    suspend fun adicionarUsuario(usuario:Usuarios)

    @Update
    suspend fun atualizarUsuario(usuario: Usuarios)

    @Delete
    suspend fun deletarUsuario(usuario: Usuarios)
}