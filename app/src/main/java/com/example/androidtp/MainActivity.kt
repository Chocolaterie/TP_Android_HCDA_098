package com.example.androidtp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtp.ui.theme.AndroidTPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginPage()
        }
    }
}

@Composable
fun LoginPage() {
    AndroidTPTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding).padding(40.dp)) {
                Text("Login", textAlign = TextAlign.Center, fontSize = 36.sp,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 100.dp))
                TextField(value = "", onValueChange = {},modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                    Text("Email")
                })
                TextField(value = "", onValueChange = {}, modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                    Text("Password")
                })
                ElevatedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                    Text("Connexion")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    LoginPage()
}