package com.example.crud.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.crud.viewmodels.UsuariosViewModel
import com.example.crud.views.CadastrarUsuarioView
import com.example.crud.views.EditarUsuarioView
import com.example.crud.views.HomeView

@Composable
fun  NavManager(viewModel: UsuariosViewModel){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
            HomeView(navController,viewModel)
        }
        composable("adicionar"){
            CadastrarUsuarioView(navController,viewModel)
        }

        composable("editar/{id}/{usuario}/{email}", arguments = listOf(
            navArgument("id"){type = NavType.IntType},
            navArgument("usuario"){type = NavType.StringType},
            navArgument("email"){type = NavType.StringType},

        )){
            EditarUsuarioView(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments!!.getString("usuario"),
                it.arguments!!.getString("email")
                )
        }
    }

}