package com.example.androidtp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidtp.article.ListArticlePage
import com.example.androidtp.article.ListArticleViewModel
import com.example.androidtp.auth.AuthViewModel
import com.example.androidtp.auth.LoginPage
import com.example.androidtp.auth.ResetPasswordPage
import com.example.androidtp.auth.SignUpPage

class MainActivity : ComponentActivity() {

    lateinit var authViewModel : AuthViewModel;
    lateinit var listArticleViewModel : ListArticleViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instancier les view models
        authViewModel = AuthViewModel()
        listArticleViewModel = ListArticleViewModel()

        enableEdgeToEdge()
        setContent {
            MainActivityPage(authViewModel, listArticleViewModel)
        }
    }
}

@Composable
fun MainActivityPage(authViewModel : AuthViewModel, listArticleViewModel : ListArticleViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"){

        composable("login") { LoginPage(authViewModel, navController) }
        composable("signUp") { SignUpPage(authViewModel, navController) }
        composable("resetPassword") { ResetPasswordPage(authViewModel) }
        composable("listArticle") { ListArticlePage(listArticleViewModel) }
    }
}

@Composable
@Preview
fun MainActivityPagePreview() {

    // Instancier les view models
    val authViewModel = AuthViewModel()

    // Récupérer le context d'application dans le Preview de l'IDE
    val listArticleViewModel = ListArticleViewModel()

    MainActivityPage(authViewModel, listArticleViewModel)
}