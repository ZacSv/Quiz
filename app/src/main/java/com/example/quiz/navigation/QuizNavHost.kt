package com.example.quiz.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.ui.feature.auth.AuthViewModel
import com.example.quiz.ui.feature.login.LoginScreen

import com.example.quiz.ui.feature.singup.SignupScreen
import kotlinx.serialization.Serializable

// --- ROTAS ---
@Serializable
object LoginRoute

@Serializable
object SignupRoute // <-- 1. Rota reativada

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = LoginRoute) {

        // --- LOGIN ---
        composable<LoginRoute> {
            LoginScreen(
                viewModel = authViewModel,
                navigateToHome = {
                    // TODO: Implementar quando tivermos a tela de Lista de Quizzes
                },
                navigateToSignup = {
                    // 2. Ação do botão ativada! Vai navegar para a tela de Cadastro
                    navController.navigate(SignupRoute)
                }
            )
        }

        // --- CADASTRO ---
        // 3. O bloco da tela de Cadastro reativado
        composable<SignupRoute> {
            SignupScreen(
                viewModel = authViewModel,
                navigateToHome = {
                    navController.navigate(LoginRoute) {
                        popUpTo(LoginRoute) { inclusive = true }
                    }
                },
                navigateToLogin = {
                    navController.popBackStack()
                }
            )
        }
    }
}