package com.example.androidtp.article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.androidtp.R
import com.example.androidtp.ui.theme.EniButton
import com.example.androidtp.ui.theme.EniPage
import com.example.androidtp.ui.theme.TitlePage
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
            TitlePage(text = stringResource(R.string.app_title_articles), verticalPadding = 20.dp)
            EniButton(buttonText = "Recharger les articles", onClick = {
                viewModel.reloadArticles()
            })
            LazyColumn {
                items(articlesState) { article ->
                    WrapPadding {
                        ElevatedCard() {
                            Row(modifier = Modifier.padding(vertical = 10.dp)) {
                                AsyncImage(
                                    model = article.imgPath,
                                    placeholder = painterResource(R.drawable.placeholder_article),
                                    contentDescription = null,
                                    modifier = Modifier.width(96.dp).height(96.dp).padding(5.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Column(modifier = Modifier.padding(horizontal = 10.dp)) {
                                    Text(
                                        text = "${article.title}",
                                        modifier = Modifier.fillMaxWidth(),
                                        color = Color.Black, fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "${article.desc}",
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