package com.example.androidtp.article

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.R
import com.example.androidtp.helpers.AppDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel(application: Application) : AndroidViewModel(application) {

    // Une liste d'article
    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    fun reloadArticles() {

        // Récupérer le message traduit
        val message = getApplication<Application>().getString(R.string.app_msg_loading_articles)

        // Afficher la popup avec message traduit
        AppDialogHelpers.get().showDialog(message)

        viewModelScope.launch { // tâche async

            // Simuler 1 second de lag en dev pour avoir le temps de voir la popup
            delay(1000)

            // Maintenant ca devient :
            // Code
            // Message
            // Data : List<Article>
            val apiResponse = ArticleService.ArticleApi.articleService.getArticles()

            // Bon : Tache fini
            // Fermer l'ecran de chargement
            AppDialogHelpers.get().closeDialog()

            // Afficher le message popup
            // TODO : Pour le moment la popup = message console
            println(apiResponse.message)

            // Tester si OK : 200
            if (apiResponse.code.equals("200")){
                articles.value = apiResponse.data!!
            }
        }
    }
}