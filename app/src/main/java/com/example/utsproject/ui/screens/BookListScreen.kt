package com.example.utsproject.ui.screen

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
import com.example.utsproject.data.model.Book

val book = Book(
    id = 1,
    title = "The Great Gatsby",
    author = "F. Scott Fitzgerald",
    publicationYear = null,
    genre = null,
    summary = "A novel set in the Roaring Twenties, exploring themes of wealth, society, and the American dream."
)

@Composable
fun BookListScreen(modifier: Modifier = Modifier) {
    Text(
        text = "${book.title}",
        modifier = modifier
    )
}

