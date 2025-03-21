package com.example.androidtp.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class ArticleActivity : ComponentActivity() {

    lateinit var listArticleViewModel : ListArticleViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listArticleViewModel = ListArticleViewModel()

        enableEdgeToEdge()
        setContent {
            ArticleActivityPage(listArticleViewModel)
        }
    }
}

@Composable
fun ArticleActivityPage(listArticleViewModel : ListArticleViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "listArticle"){

        composable("listArticle") { ListArticlePage(listArticleViewModel) }
    }
}

@Composable
@Preview
fun ArticleActivityPagePreview() {

    // Récupérer le context d'application dans le Preview de l'IDE
    val listArticleViewModel = ListArticleViewModel()

    ArticleActivityPage(listArticleViewModel)
}