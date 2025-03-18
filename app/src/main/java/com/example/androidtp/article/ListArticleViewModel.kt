package com.example.androidtp.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.article.Article
import com.example.androidtp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel : ViewModel() {

    // Une liste d'article
    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    fun reloadArticles() {

        AppDialogHelpers.get().showDialog("Chargement des articles en cours...")

        viewModelScope.launch { // tâche async

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            val apiResponse = ArticleService.ArticleApi.articleService.getArticles()

            articles.value = apiResponse

            // Bon : Tache fini
            // Fermer l'ecran de chargement
            AppDialogHelpers.get().closeDialog()
        }
    }
}