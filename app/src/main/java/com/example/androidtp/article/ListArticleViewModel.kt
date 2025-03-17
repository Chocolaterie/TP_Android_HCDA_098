package com.example.androidtp.article

import androidx.lifecycle.ViewModel
import com.example.androidtp.article.Article
import kotlinx.coroutines.flow.MutableStateFlow

class ListArticleViewModel : ViewModel() {

    // Une liste d'article
    var articles = MutableStateFlow<List<Article>>(
        mutableListOf(
            Article("GTX 5080", "Todo", "https://en.meming.world/images/en/b/b1/Dust_Storm_Dog.jpg"),
            Article("Pizza Ananas", "Meilleur pizza au monde", "https://en.meming.world/images/en/b/b1/Dust_Storm_Dog.jpg"))
    )
}