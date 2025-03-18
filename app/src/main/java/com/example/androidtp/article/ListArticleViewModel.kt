package com.example.androidtp.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidtp.article.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ListArticleViewModel : ViewModel() {

    // Une liste d'article
    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    fun reloadArticles() {

        viewModelScope.launch {

            val apiResponse = ArticleService.ArticleApi.articleService.getArticles()

            articles.value = apiResponse
        }
    }
}