package com.example.utsproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.utsproject.ui.theme.UTSProjectTheme
import com.example.utsproject.ui.screen.BookListScreen
import com.example.utsproject.ui.screen.AddBookScreen
import com.example.utsproject.ui.viewmodel.BookViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UTSProjectTheme {
                // val bookViewModel: BookViewModel = viewModel()
              Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                AddBookScreen(
                    modifier = Modifier.padding(innerPadding)
                    // viewModel = bookViewModel,
                    // onBookAdded = { }
                )
              }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UTSProjectTheme {
        Greeting("Android")
    }
}
