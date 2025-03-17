package com.example.androidtp.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.androidtp.ui.theme.EniPage
import com.example.androidtp.ui.theme.WrapPadding

class ListArticleActivity : ComponentActivity() {

    // Déclarer un view model
    var viewModel = ListArticleViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            ListArticlePage(viewModel)
        }
    }
}

@Composable
fun ListArticlePage(viewModel: ListArticleViewModel) {
    // J'ecoute les changements de la liste des persons dans le view model en temps réel
    val articlesState by viewModel.articles.collectAsState()

    EniPage {
        Column(modifier = Modifier.padding(30.dp)) {
            LazyColumn {
                items(articlesState) { article ->
                    WrapPadding {
                        ElevatedCard() {
                            Row(modifier = Modifier.padding(vertical = 10.dp)) {
                                AsyncImage(
                                    model = "https://en.meming.world/images/en/b/b1/Dust_Storm_Dog.jpg",
                                    contentDescription = null,
                                    modifier = Modifier.width(96.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Column {
                                    Text(
                                        text = "${article.title}",
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.Black, fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "${article.description}",
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.Black,
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListArticlePreview() {

    // Déclarer un view model
    var viewModel = ListArticleViewModel()

    ListArticlePage(viewModel)
}