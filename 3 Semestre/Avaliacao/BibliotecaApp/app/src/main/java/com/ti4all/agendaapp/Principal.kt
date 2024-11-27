package com.ti4all.agendaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ti4all.agendaapp.model.CategoriaViewModel
import com.ti4all.agendaapp.model.LivroViewModel
import com.ti4all.agendaapp.ui.theme.AgendaAppTheme
import com.ti4all.agendaapp.view.TelaCategorias
import com.ti4all.agendaapp.view.TelaLivros

class Principal : ComponentActivity() {
    private val livroViewModel: LivroViewModel by viewModels()
    private val categoriaViewModel: CategoriaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendaAppTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "TelaLivros"){
                    composable(
                        route = "TelaLivros"
                    ) {
                        TelaLivros(navController, livroViewModel, categoriaViewModel)
                    }

                    composable(
                        route = "TelaCategorias"
                    ) {
                        TelaCategorias(navController, categoriaViewModel)
                    }
                }
            }
        }
    }
}
