package com.example.crud.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.crud.models.Usuarios

@Database(
    entities = [Usuarios::class],
    version = 1,
    exportSchema = false
)
abstract class UsuariosDataBase: RoomDatabase() {
    abstract fun usuariosDao(): UsuariosDataBaseDao
}