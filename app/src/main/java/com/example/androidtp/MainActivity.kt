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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MainActivityPage()
        }
    }
}

@Composable
fun MainActivityPage() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"){

        composable("login") { LoginPage(navController) }
        composable("signUp") { SignUpPage(navController) }
        composable("resetPassword") { ResetPasswordPage() }
    }
}

@Composable
@Preview
fun MainActivityPagePreview() {

    MainActivityPage()
}