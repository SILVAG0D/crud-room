package com.example.crud.states

import com.example.crud.models.Usuarios

data class UsuariosState(
    val listaUsuarios: List<Usuarios> = emptyList()

)
