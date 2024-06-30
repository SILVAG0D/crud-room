package com.example.crud.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crud.models.Usuarios
import com.example.crud.room.UsuariosDataBaseDao
import com.example.crud.states.UsuariosState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class UsuariosViewModel(
    private val dao: UsuariosDataBaseDao
): ViewModel() {

    var state by mutableStateOf(UsuariosState())
        private set

    init {
        viewModelScope.launch {
            dao.obterUsuarios().collectLatest {
                state = state.copy(
                    listaUsuarios = it
                )
            }
        }
    }

    fun adicionarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.adicionarUsuario(usuario = usuario)
    }

    fun atualizarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.atualizarUsuario(usuario = usuario)
    }

    fun deletarUsuario(usuario: Usuarios) = viewModelScope.launch {
        dao.deletarUsuario(usuario = usuario)
    }
}