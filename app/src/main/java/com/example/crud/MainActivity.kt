package com.example.crud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.example.crud.navigation.NavManager
import com.example.crud.room.UsuariosDataBase
import com.example.crud.ui.theme.CrudTheme
import com.example.crud.viewmodels.UsuariosViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrudTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this,UsuariosDataBase::class.java,"db_usuarios").build()
                    val dao = database.usuariosDao()
                    
                    val viewModel = UsuariosViewModel(dao)
                    
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}

