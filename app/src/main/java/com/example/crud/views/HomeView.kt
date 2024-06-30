package com.example.crud.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.crud.viewmodels.UsuariosViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController, viewModel: UsuariosViewModel){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                                    Text(text = "HomeView", color = Color.White, fontWeight = FontWeight.Bold)
            },
              colors = centerAlignedTopAppBarColors(
                  containerColor = MaterialTheme.colorScheme.primary
              )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("adicionar") },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White
            ) {
                Icon(
                   imageVector = Icons.Default.Add,contentDescription = "Cadastrar Usuario"
                )
            }
        }
    ) {
        ContentHomeView(it,navController,viewModel)
    }
}

@Composable
fun ContentHomeView(it:PaddingValues,navController: NavController, viewModel: UsuariosViewModel){
    val state = viewModel.state

    Column(
        modifier = Modifier.padding(it)
    ) {
        LazyColumn(

        ) {
            items(state.listaUsuarios){
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ){
                    Column(
                        modifier = Modifier.padding(12.dp)
                    ) {
                        Text(text = it.usuario)
                        Text(text = it.email)
                        IconButton(
                            onClick = { navController.navigate("editar/${it.id}/${it.usuario}/${it.email}") }
                        ) {
                            Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar Usuario")
                        }

                        IconButton(onClick = { viewModel.deletarUsuario(it) }
                        ) {
                            Icon(imageVector = Icons.Default.Delete, contentDescription = "Deletar Usuario")
                        }
                    }
                }
            }
        }
    }
}