package com.example.androidtp.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.AppViewHelper
import com.example.androidtp.R
import com.example.androidtp.helpers.AppAlertDialogHelpers
import com.example.androidtp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel() : ViewModel() {

    // Une liste d'article
    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    fun reloadArticles() {

        // Récupérer le message traduit
        var message = "Chargement des articles en cours..."

        // Afficher la popup avec message traduit
        AppDialogHelpers.get().showDialog(message)

        viewModelScope.launch { // tâche async

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            // Maintenant ca devient :
            // Code
            // Message
            // Data : List<Article>
            try {
                val apiResponse = ArticleService.ArticleApi.articleService.getArticles()

                // Bon : Tache fini
                // Fermer l'ecran de chargement
                AppDialogHelpers.get().closeDialog()

                // Afficher le message popup
                AppAlertDialogHelpers.get().show(apiResponse.message)

                // Tester si OK : 200
                if (apiResponse.code.equals("200")) {
                    articles.value = apiResponse.data!!
                }
            } catch (e: Exception) {
                AppViewHelper.catchDialogHelper("Erreur inconnue")
            }
        }
    }
}