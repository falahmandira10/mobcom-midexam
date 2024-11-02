package com.example.utsproject.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import com.example.utsproject.data.model.Book
import com.example.utsproject.data.model.Genre
import com.example.utsproject.ui.viewmodel.BookViewModel

@Composable
fun AddBookScreen(
    // viewModel: BookViewModel,
    // onBookAdded: () -> Unit,
    modifier: Modifier = Modifier
) {
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("") }
    var publicationYear by remember { mutableStateOf("") }
    var genre by remember { mutableStateOf(Genre.ROMANCE) }
    var summary by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        
        TextField(
            value = author,
            onValueChange = { author = it },
            label = { Text("Author") }
        )

        TextField(
            value = publicationYear,
            onValueChange = { publicationYear = it },
            label = { Text("Publication Year") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        DropdownMenuGenreSelector(selectedGenre = genre, onGenreSelected = { genre = it })

        TextField(
            value = summary,
            onValueChange = { summary = it },
            label = { Text("Summary") },
            modifier = Modifier.height(150.dp)
        )

        Button(
            onClick = {
                // if (title.isNotBlank() && author.isNotBlank()) {
                //     val book = Book(
                //         id = 0,
                //         title = title,
                //         author = author,
                //         publicationYear = publicationYear.toIntOrNull(),
                //         genre = genre,
                //         summary = summary
                //     )
                //     viewModel.addBook(book)
                //     onBookAdded()
                // }
            },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Add Book")
        }
    }
}

@Composable
fun DropdownMenuGenreSelector(
    selectedGenre: Genre,
    onGenreSelected: (Genre) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    val interactionSource = remember { MutableInteractionSource() }
    
    Box {
        Text(
            text = selectedGenre.name,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { expanded = true }
                .padding(16.dp)
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Genre.values().forEach { genre ->
                DropdownMenuItem(
                    text = { Text(text = genre.name) },
                    onClick = {
                        onGenreSelected(genre)
                        expanded = false
                    }
                )
            }
        }
    }
}
