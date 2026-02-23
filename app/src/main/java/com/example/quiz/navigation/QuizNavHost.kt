package com.example.quiz.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.ui.feature.auth.AuthViewModel
import com.example.quiz.ui.feature.login.LoginScreen
import kotlinx.serialization.Serializable

// --- ROTAS ---
@Serializable
object LoginRoute

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    // O Hilt injeta o seu AuthViewModel automaticamente aqui
    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = LoginRoute) {

        // --- LOGIN ---
        composable<LoginRoute> {
            LoginScreen(
                viewModel = authViewModel,
                navigateToHome = {
                    // TODO: Implementar depois quando a tela principal do Quiz existir
                },
                navigateToSignup = {
                    // TODO: Implementar depois quando reativarmos a rota de Cadastro
                }
            )
        }
    }
}